public class User {
    private String name;
    private int cedula;

    //Constructor

    public User(String name, int cedula) {
        this.name = name;
        this.cedula = cedula;
    }
    //Getter y Setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    //Métodos de la clase
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", cedula=" + cedula +
                '}';
    }
}
