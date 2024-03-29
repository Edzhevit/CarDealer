package cardealer.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;


    // first of all type in your password in application.properties to connect to database
    // seed all entities from your resources in your files and export cars to typed output

@Controller
public class BaseController implements CommandLineRunner {

    private final ImportController importController;
    private final ExportController exportController;

    @Autowired
    protected BaseController(ImportController importController, ExportController exportController) {
        this.importController = importController;
        this.exportController = exportController;
    }

    @Override
    public void run(String... args) throws Exception {
//        this.importController.seedSuppliers();
//        this.importController.seedParts();
//        this.importController.seedCars();
//        this.importController.seedCustomers();
//        this.exportController.exportCars();
    }
}
