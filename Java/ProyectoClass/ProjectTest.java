import java.util.ArrayList;
import java.util.Arrays;


public class ProjectTest {
    public static void main(String[] args) {
        Project p1 = new Project();
        p1.setNombre("Vacaciones");
        p1.setDescripcion("Viajar al sur");
        System.out.println(p1.elevatorPitch());

        Project p2 = new Project("Ahorrar");
        p2.setNombre("Nombre proyecto 2");
        p2.setDescripcion("Descripcion proyecto 2");
        System.out.println(p2.elevatorPitch());

        Project p3 = new Project("Cocinar ", "Se debe cocinar la cena de navidad");
        System.out.println(p3.elevatorPitch());

        //Agregar costo inicial a los proyectos
        p1.setInitialCost(500000);
        p2.setInitialCost(100000);
        p3.setInitialCost(300000);


        //se crea una lista de tipo clase Proyect para almacenar los objetos
        ArrayList<Project> listaProject =new ArrayList<Project>();
        listaProject.addAll(Arrays.asList(p1,p2,p3));

        //se crea un objeto portafolio donde a ese portafolio se le asigna los 3 proyectos
        Portafolio portafolio = new Portafolio();
        portafolio.setProject(listaProject);

        portafolio.showPortfolio();
        
    }
}
