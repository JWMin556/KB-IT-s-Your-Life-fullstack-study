package org.scoula.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;


//Tomcat에게 알리는 용도 (기존의 Web.xml을 대체한다)
public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    final String LOCATION = "c:/upload";
    final long MAX_FILE_SIZE = 1024 * 1024 * 10L;
    final long MAX_REQUEST_SIZE = 1024 * 1024 *20L;
    final int FILE_SIZE_THRESHOLD = 1024 * 1024 * 5;;

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {
                RootConfig.class
        };
        // ✅ 루트 컨텍스트 설정 클래스 등록
        //    → 트랜잭션, 서비스, @ComponentScan 등 공통 설정
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {
                ServletConfig.class,
                WebSocketConfig.class
        };
        // ✅ 서블릿(Web) 컨텍스트 설정 클래스 등록
        //    → DispatcherServlet에 연결되는 웹 관련 설정들
        //    → WebSocketConfig 등록으로 웹소켓 메시지 브로커 활성화됨
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }


    // POSTbody문자인코딩필터설정-UTF-8설정
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter= new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return new Filter[] {characterEncodingFilter};
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setInitParameter("throwExceptionIfNoHandlerFound", "true");
        MultipartConfigElement multipartConfig =
                new MultipartConfigElement(
                        LOCATION, // 업로드처리디렉토리경로
                        MAX_FILE_SIZE, // 업로드가능한파일하나의최대크기
                        MAX_REQUEST_SIZE, //업로드가능한전체최대크기(여러파일업로드하는경우)
                        FILE_SIZE_THRESHOLD // 메모리파일의최대크기(이보다작으면실제메모리에서만작업)
                );
        registration.setMultipartConfig(multipartConfig);
    }
}
