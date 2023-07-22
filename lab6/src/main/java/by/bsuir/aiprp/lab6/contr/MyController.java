package by.bsuir.aiprp.lab6.contr;

import by.bsuir.aiprp.lab6.model.Car;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

public class MyController implements Controller {

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        CarManager carManager = new CarManager();
        ModelAndView modelAndView;
        String command = String.valueOf(request.getParameter("command"));
        switch (command) {
            case "cars":
                modelAndView = new ModelAndView("cars.jsp");
                modelAndView.addObject("carList", carManager.getCarList());
                break;
            case "priceByModel":
                modelAndView = new ModelAndView("findByModel.jsp");
                String model = String.valueOf(request.getParameter("model"));
                if (!model.equals("null") && !model.equals("")) {
                    Optional<Car> car = carManager.findByModel(model);
                    if (car.isPresent()) {
                        modelAndView.addObject("car", car.get());
                    } else {
                        request.setAttribute("errorMsg", "No such car!");
                    }
                }
                break;
            case "carsCheaperThanPrice":
                modelAndView = new ModelAndView("cheaperCars.jsp");
                String carPrice = String.valueOf(request.getParameter("price"));
                if (!carPrice.equals("null") && !carPrice.equals("")) {
                    List<Car> cars = carManager.cheaperThan(Integer.parseInt(carPrice));
                    if (cars.size() > 0) {
                        modelAndView.addObject("carList", cars);
                    } else {
                        request.setAttribute("errorMsg", "No such cars!");
                    }
                }
                break;
            case "add":
                String newModel = String.valueOf(request.getParameter("model"));
                String newPrice = String.valueOf(request.getParameter("price"));
                if(!newModel.equals("null") && !newModel.equals("") &&
                        !newPrice.equals("null") && !newPrice.equals("")) {
                    carManager.addNewCar(newModel, Integer.parseInt(newPrice));
                    modelAndView = new ModelAndView("cars.jsp");
                    modelAndView.addObject("carList", carManager.getCarList());
                } else {
                    modelAndView = new ModelAndView("newCar.jsp");
                }
                break;
            default:
                modelAndView = new ModelAndView("main.jsp");
                break;
        }
        return modelAndView;
    }
}
