package org.kodluyoruz;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

@Configuration
public class WebAppInitializer implements WebApplicationInitializer {

    /*
    * Spring 4+ ile birlikte WebApplicationInitializer arayuzu implemente edilerek override edilen onStartup metodunda
    * Dispatcher Servlet tanımlanabilmektedir.
    * */
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context = getContext();
        servletContext.addListener(new ContextLoaderListener(context));
        ServletRegistration.Dynamic dispatcherServlet =
                servletContext.addServlet("DispatcherServlet",new DispatcherServlet(context));
        dispatcherServlet.setLoadOnStartup(1);
        dispatcherServlet.addMapping("/");

        /*
        * WebFilter belirtilen HTTP isteklerinin tamamına uygulanır.
        * Dispatcher Servlet den once isleme alınır.
        * Genelde karakter kodlaması ve sıkıstırma gibi temel islemler icin kullanılır.
        * Spring4+ icin tanımı asagıdaki gibidir.
        * */
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        characterEncodingFilter.setForceRequestEncoding(true);
        characterEncodingFilter.setForceResponseEncoding(true);
        servletContext.addFilter("characterEncodingFilter",characterEncodingFilter)
                .addMappingForUrlPatterns(null,false,"/*");

    }
    private AnnotationConfigWebApplicationContext getContext(){
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setConfigLocation("org.kodluyoruz");
        return context;
    }
}
