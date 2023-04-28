import java.util.ArrayList;

public class Portafolio {
    // Crear una clase Portfolio que tendrá un Arraylist de Project en el campo 
    private ArrayList<Project> projects;
    public Portafolio(){
    }
    public ArrayList<Project> getProject() {
        return projects;
    }
    public void setProject(ArrayList<Project> projects) {
        this.projects = projects;
    }

   public double getPortafolioCost(){
       double costoTotal =0;
       for (Project proyecto : projects) {
        costoTotal+=proyecto.getInitialCost();
       }
       return costoTotal;
   }
   public void showPortfolio(){
    for (Project project : projects) {
        System.out.println(project.elevatorPitch());
    }
    System.out.println(String.format("Total de costo: %d", (int) getPortafolioCost()));
   }

}
