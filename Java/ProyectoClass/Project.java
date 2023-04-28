public class Project {
  private String nombre;
  private String descripcion;
  private double initialCost;

  public Project() {
  }

  public Project(String nombre) {
    this.nombre = nombre;
  }

  public Project(String nombre, String descripcion) {
    this.nombre = nombre;
    this.descripcion = descripcion;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public double getInitialCost() {
    return initialCost;
  }

  public void setInitialCost(double initialCost) {
    this.initialCost = initialCost;
  }

  public String elevatorPitch() {
    return this.nombre + ": " + this.descripcion;
  }
}