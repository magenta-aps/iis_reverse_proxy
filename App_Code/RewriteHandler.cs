using System;
using System.Web;
using System.Net;
using System.Text;
using System.Text.RegularExpressions;
using System.Linq;

public class RewriteHandler : IHttpHandler
{
    /// <summary>
    /// You will need to configure this handler in the web.config file of your 
    /// web and register it with IIS before being able to use it. For more information
    /// see the following link: http://go.microsoft.com/?linkid=8101007
    /// </summary>


    public bool IsReusable
    {
        // Return false in case your Managed Handler cannot be reused for another request.
        // Usually this would be false in case you have some state information preserved per request.
        get { return true; }
    }

    public void ProcessRequest(HttpContext context)
    {
        var url = System.Configuration.ConfigurationManager.AppSettings["RewriteUrl"]
            + context.Request.Path;

        System.Net.HttpWebRequest req = System.Net.WebRequest.Create(url) as HttpWebRequest;
        req.Method = context.Request.HttpMethod;
        req.AllowAutoRedirect = false; // Send redirect bach to browser           

        // Copy request headers
        foreach (var headerKey in context.Request.Headers.AllKeys)
        {
            var val = context.Request.Headers[headerKey];
            switch (headerKey.ToLower())
            {
                case "connection":
                    if (val.ToLower().Equals("keep-alive"))
                        req.KeepAlive = true;
                    else if (val.ToLower().Equals("close"))
                        req.KeepAlive = false;
                    else
                        req.Connection = val;
                    break;

                case "accept":
                    req.Accept = val;
                    break;

                case "host":
                    req.Host = val;
                    break;

                case "user-agent":
                    req.UserAgent = val;
                    break;

                case "content-length":
                    req.ContentLength = int.Parse(val);
                    break;

                case "content-type":
                    req.ContentType = val;
                    break;

                case "referer":
                    req.Referer = val;
                    break;

                default:
                    req.Headers[headerKey] = val;
                    break;
            }
        }

        // Copy user identity
        if (context.User != null && context.User.Identity != null)
        {
            //"PLAY_SESSION=\"c2473fd670659d53d132999260be173a0f3cd99d-username=test\"; Path=/; HTTPOnly"
            var ss = req.Headers[HttpRequestHeader.Cookie];
            var cookies = CookieParser.Parse(ss).ToList();
            /*var sessionCookie = cookies.Where(c => c is PlaySessionCookie).FirstOrDefault() as PlaySessionCookie;
            if (sessionCookie == null)
            {
                sessionCookie = new PlaySessionCookie("");
                cookies.Add(sessionCookie);
            }
            sessionCookie.Username = context.User.Identity.Name;
            sessionCookie.Username = "test";
            */
            var cookie2 = new Cookie("") { Name = "username", Value = context.User.Identity.Name };
            cookies.Add(cookie2);

            var cookiesString = CookieParser.ToString(cookies.ToArray());
            req.Headers[HttpRequestHeader.Cookie] = cookiesString;
        }

        // Copy request content
        if (req.ContentLength > 0)
        {
            using (var reqStream = req.GetRequestStream())
            {
                var reqBytes = new byte[context.Request.InputStream.Length];
                context.Request.InputStream.Read(reqBytes, 0, reqBytes.Length);
                reqStream.Write(reqBytes, 0, reqBytes.Length);
            }
        }

        // Get response
        var res = req.GetResponse() as HttpWebResponse;

        // Copy responbse headers
        foreach (var headerKey in res.Headers.AllKeys)
        {
            var val = res.Headers[headerKey];
            switch (headerKey.ToLower())
            {
                case "content-length":
                    break;

                case "content-type":
                    context.Response.ContentType = val;
                    break;

                case "location":
                    break;

                case "cache-control":
                    break;

                case "date":
                    break;
                case "etag":
                    break;
                case "last-modified":
                    break;

                case "set-cookie":
                    foreach (var cookieString in val.Split(new char[] { ';' }, StringSplitOptions.RemoveEmptyEntries))
                    {
                        var pat = @"\A(?<name>[^=]+)(=(?<val>.+))\Z";
                        var m = Regex.Match(cookieString, pat);
                        context.Response.Cookies.Add(new HttpCookie(m.Groups["name"].Value, m.Groups["val"].Value));
                    }
                    break;

                default:
                    try
                    {
                        context.Response.Headers.Add(headerKey, val);
                    }
                    catch (Exception ex)
                    {
                        throw ex;
                    }
                    break;
            }
        }

        //Copy response data or redirect
        context.Response.StatusCode = (int)res.StatusCode;
        if (res.StatusCode == HttpStatusCode.SeeOther)
        {
            context.Response.RedirectLocation = res.Headers["Location"];
        }
        else
        {
            using (var resStream = res.GetResponseStream())
            {
                if (string.IsNullOrEmpty(res.CharacterSet)) // Binary response (image)
                {
                    var resBytes = new byte[res.ContentLength];
                    resStream.Read(resBytes, 0, resBytes.Length);
                    context.Response.OutputStream.Write(resBytes, 0, resBytes.Length);
                }
                else
                {
                    var enc = Encoding.GetEncoding(res.CharacterSet); // text response
                    using (var rd = new System.IO.StreamReader(resStream))
                    {
                        var resString = rd.ReadToEnd();
                        context.Response.Output.Write(resString);
                    }
                }
            }
        }
    }
}