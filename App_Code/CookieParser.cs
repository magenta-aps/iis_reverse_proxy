using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Text.RegularExpressions;


public class CookieParser
{
    public static Cookie[] Parse(string val)
    {
        return val
            .Split(new string[] { "; " }, StringSplitOptions.RemoveEmptyEntries)
            .Select(cookieString => new Cookie(cookieString))
            .ToArray();
    }

    public static string ToString(Cookie[] cookies)
    {
        return string
            .Join("; ", cookies.Select(c => c.ToString())
            .ToArray());
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
