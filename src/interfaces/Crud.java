package interfaces;

import java.util.List;

public interface Crud<T, ID> {
    public void registar(T t) throws Exception;

    public void actualizar(T t) throws Exception;

    public void eliminar(T t) throws Exception;

    public List<T> listarTodo() throws Exception;

    public T buscarPorId(ID id) throws Exception;
}
