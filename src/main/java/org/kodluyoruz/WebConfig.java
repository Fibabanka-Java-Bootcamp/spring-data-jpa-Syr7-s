package org.kodluyoruz;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/*Web isteklerinin yürütülmesini MVC mimarisinin kullanılması için @EnableWebMvc annotation ı kullanılır.*/

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"org.kodluyoruz"})
public class WebConfig implements WebMvcConfigurer{

    /*
    * ViewResolver görüntü (view) isimlerinden fiziksel goruntu sayfalarının cozumlenmesi saglar.
    * Ornek .jsp, .html
    * Fiziksel goruntu sayfalarına tarayıcıdan dogrudan erisim saglanması engellenmek isteniyorsa prefix
    * ozelligi /WEB-INF/view/ olarak tanımlanır. Controller sınıflarından erisim saglancaktır.
    * suffix ozelligi ile goruntu katmanındaki web sayfa uzantı formatı belirlenir.
    * Ornek .jsp, .html, .xhtml, .json, .php gibi.
    * ViewResolver Spring 4+ için java tabanlı konfigurasyonudur.
    * */
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/WEB-INF/views/");
        internalResourceViewResolver.setSuffix(".jsp");
        internalResourceViewResolver.setContentType("text/html;charset=UTF-8");
        return internalResourceViewResolver;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /*
    * Response Karakter Kodlaması:
    * @RequestMapping annotation ı icinde produces attribute u ile uretilecek veri tipi ve karakter kodlaması tanımlanabilmektedir.
    * Her metot yerine tanımlamak yerine merkezi bir sekilde konfigure edilebilir.
    * Hem yonetim kolaylıgı hemde kod sadeligi saglar.
    * HTTP Response un da HTTP Request de oldugu gibi kodlanması gerekmektedir.
    * Bunun icin configureMessageConverters metodu WebConfig adından tanımlanarak override edilebilir.
    * */

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        StringHttpMessageConverter stringConverter = new StringHttpMessageConverter();

        List<MediaType> mediaTypeList = new ArrayList<>();
        mediaTypeList.add(new MediaType("text", "plain", Charset.forName("UTF-8")));
        mediaTypeList.add(new MediaType("text", "plain", Charset.forName("UTF-8")));
        mediaTypeList.add(new MediaType("application", "json", Charset.forName("UTF-8")));
        mediaTypeList.add(new MediaType("text", "javascript", Charset.forName("UTF-8")));

        stringConverter.setSupportedMediaTypes(mediaTypeList);
        converters.add(stringConverter);
    }
}
