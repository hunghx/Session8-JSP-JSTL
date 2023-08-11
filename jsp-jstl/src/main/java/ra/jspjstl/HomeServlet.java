package ra.jspjstl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "HomeServlet", value = "/HomeServlet")
public class HomeServlet extends HttpServlet {
    protected List<User> list ;

    @Override
    public void init() throws ServletException {
        list= new ArrayList<>();
        list.add(new User("hung@gmail.com","Hồ Xuân Hùng","123456"));
        list.add(new User("minh@gmail.com","Nguyễn Đức Minh","123456"));
        list.add(new User("nam@gmail.com","Nguyễn Phương Nam","123456"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        System.out.println("Vào do get của homeServlet");

        String action = request.getParameter("action");
        switch (action) {
            case "Home":
                // ttruyeenf dữ liệu vào đối tượng request
                List<Integer> list = new ArrayList<>();
                list.add(1);
                list.add(2);
                list.add(3);
                list.add(4);
                request.setAttribute("name","Nguyễn Văn A");
                request.setAttribute("obj",list);
                request.getRequestDispatcher("/view/home.jsp").forward(request, response);
                break;

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action!=null){
            switch (action){
                case "LOGIN":
                    String email = request.getParameter("email");
                    String password = request.getParameter("password");
                    User u = checkLogin(email,password);
                    if(u!=null){
                        request.setAttribute("user",u);
                        request.getRequestDispatcher("/view/home.jsp").forward(request,response);
                    }else {
                        request.setAttribute("email",email);
                        request.setAttribute("password",password);
                        request.setAttribute("error","Tài khaonr hoặc mật khẩu không đùng");
                        request.getRequestDispatcher("/view/login.jsp").forward(request,response);
                    }
            }
        }
    }
    protected User checkLogin(String email, String password){
        for (User u: list
             ) {
            if(u.getEmail().equalsIgnoreCase(email)&&u.getPassword().equalsIgnoreCase(password)){
                return u;
            }
        }
        return null;
    }
}