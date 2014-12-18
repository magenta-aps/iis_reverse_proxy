using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Text.RegularExpressions;


public class CookieParser
{
    public static Cookie[] Parse(string val)
    {
        var map = new Dictionary<string, Type>();
        map["PLAY_SESSION"] = typeof(PlaySessionCookie);

        var ret = new List<Cookie>();
        foreach (var cookieString in val.Split(new string[] { "; " }, StringSplitOptions.RemoveEmptyEntries))
        {
            var cookie = new Cookie(cookieString);
            if(cookie.Name.Trim().Equals("PLAY_SESSION"))
                cookie = new PlaySessionCookie(cookieString);
            ret.Add(cookie);
        }
        return ret.ToArray();
    }

    public static string ToString(Cookie[] cookies)
    {
        return string.Join("; ", cookies.Select(c => c.ToString()).ToArray());
    }
}

public class Cookie
{
    public string Name;
    public string Value;

    public const string MatchPattern = @"\A(?<name>[^=]+)(=(?<val>.+))\Z";
    public Cookie(string cookieString)
    {
        var pat = @"\A(?<name>[^=]+)(=(?<val>.+))\Z";
        var m = Regex.Match(cookieString, pat);
        Name = m.Groups["name"].Value;
        Value = m.Groups["val"].Value;
    }

    public override string ToString()
    {
        return string.Format("{0}={1}", Name, Value);
    }
}

public class PlaySessionCookie : Cookie
{
    //"PLAY_SESSION=\"c2473fd670659d53d132999260be173a0f3cd99d-username=test\"; Path=/; HTTPOnly"
    public string SessionId;
    public string Username;
    public string Other;
    public PlaySessionCookie(string cookieString)
        : base(cookieString)
    {
        if (!string.IsNullOrEmpty(Value))
        {
            var pat = "\"(?<sessionId>[0-9a-z]+)-username=(?<username>[^&;\"=]+)(?<other>.+)?\"";
            var m = Regex.Match(Value, pat);
            SessionId = m.Groups["sessionId"].Value;
            Username = m.Groups["username"].Value;
            Other = m.Groups["other"].Value;
        }
    }

    public override string ToString()
    {
        Value = string.Format("\"{0}-username={1}{2}\"", SessionId, Username, Other);
        return base.ToString();
            
            
    }
}
