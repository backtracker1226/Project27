package org.zerock.listen;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

import org.zerock.persistence.BoardDAO;

/**
 * Application Lifecycle Listener implementation class SampleListener
 *
 */
@WebListener
public class SampleListener implements ServletContextListener, ServletRequestListener {

    /**
     * Default constructor. 
     */
    public SampleListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
     */
    public void requestDestroyed(ServletRequestEvent sre)  { 
    	
         // TODO 접속한 상대의 아이피 주소를 스트링에 저장한다.
    	String addr = sre.getServletRequest().getRemoteAddr();
    	
    	System.out.println(addr);
    }

	/**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    public void requestInitialized(ServletRequestEvent sre)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    
    // WAS를 닫을때 이벤트
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    
    // WAS가 로딩 될때 이벤트
    // 대표적인 작업으로 커넥션 풀링을 한다. (DB 연결 등)
    public void contextInitialized(ServletContextEvent sce)  { 
         // Context는 라이프 사이클, 범위(공간) 이 두가지를 기억하자
    	ServletContext ctx = sce.getServletContext();
    	
    	
    	ctx.setAttribute("logo", "Nolran");
    	
    	// util 이라고 정하고 RequestUtil을 실행 할 수 있도록 한다.
    	ctx.setAttribute("util", new RequestUtil());
    	
    	
    	// BoardDAO를 싱글턴 패턴으로 만들어준다
    	try {
			ctx.setAttribute("boardDAO", new BoardDAO());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	for(int i=0; i<10; i++){
    		System.out.println("Context init...." + i);
    	}
    } // end Initialized
	
}
