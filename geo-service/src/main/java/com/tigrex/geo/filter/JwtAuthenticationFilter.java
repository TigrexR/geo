package com.tigrex.geo.filter;

import com.tigrex.geo.entity.bo.UserDetailsBO;
import com.tigrex.geo.entity.query.UserQuery;
import com.tigrex.geo.utils.JacksonUtils;
import com.tigrex.geo.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author linus
 */
@Slf4j
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    /**
     * 验证用户名密码是否正确之后，生成一个token，并将token返回客户端
     *
     * @param request
     * @param response
     * @return
     * @throws AuthenticationException
     */

    private String secretKey = "ILoveDanChaoFan";

    private AuthenticationManager authenticationManager;

    /**
     * 下面是为了配置这个Manager
     * 配置其拦截的API请求地址
     *
     * @param authenticationManager
     */
    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        //这里指定什么样的API请求会被这个过滤器拦截
        super.setFilterProcessesUrl("/user/login");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        //这里是定义一个拦截器，在认证方面的拦截器，当请求的时候回拦截到这里面然后进行身份认证
        //验证用户名密码是否正确之后
        try {
            System.out.println("InputStream:" + request.getInputStream());
            UserQuery userQuery = JacksonUtils.getJackson().readValue(request.getInputStream(), UserQuery.class);
            //对于这个过滤器拦截的接口，去调用SpringSecurity默认的认证程序，也就是去进行SpringSecurity的认证
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    userQuery.getUsername(), userQuery.getPassword()));
            //如果返回成功，就进入successfulAuthentication。
            //返回失败就进入unsuccessfulAuthentication
            //这个地方还有点问题，如果密码错误了，就会报BadCredentialsException错误。需要看一下如果不让这么报错并让他进入到unsuccessfulAuthentication方法中
        } catch (BadCredentialsException e) {
            //捕捉密码验证错误异常
            log.info("密码错误");
            try {
                this.unsuccessfulAuthentication(request, response, e);
            } catch (IOException | ServletException ex) {
                ex.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void successfulAuthentication(
            HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult)
            throws IOException, ServletException {
        //当身份验证通过之后，会进入这里，这里可以定义成功的返回
        //将principal中的信息转换成User对象
//        UserDetailsBO user = (UserDetailsBO) authResult.getPrincipal();
//        String token = JwtUtils.createToken("geo", "swc", user, 3600000L);
//        response.addHeader("Authorizations", token);
        //需要将生成的jwtToken回传
        System.out.println(JacksonUtils.getJackson().writeValueAsString(authResult));
        System.out.println("认证成功");
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        //TODO 得看一下为啥会报这个错误
        System.out.println("认证失败");
    }
}
