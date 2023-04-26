import dao.PersonaImpl;
import interfaces.DaoPersona;
import model.Persona;

public class App {
    public static void main(String[] args) throws Exception {
        Persona persona = new Persona();
        // persona.setId(1);
        persona.setNombre("Gabriel");

        try {
            DaoPersona dao = new PersonaImpl();
            // dao.registar(persona);
            System.out.println(dao.buscarPorId(2));
            for (Persona p : dao.listarTodo()) {
                System.out.println(p.getNombre());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
