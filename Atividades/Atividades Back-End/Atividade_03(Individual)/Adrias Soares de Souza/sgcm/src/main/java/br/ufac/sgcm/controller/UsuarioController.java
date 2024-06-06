public class UsuarioController implements IController<Usuario> {

    private UsuarioDao eDao;

    public UsuarioController() {
        eDao = new UsuarioDao();
    }

    @Override
    public List<Usuario> get() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public Usuario get(Long id) {
        Usuario registro = eDao.get(id);
        return registro;
    }

    @Override
    public List<Usuario> get(String termoBusca) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public int delete(Usuario objeto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public int save(Usuario objeto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public List<Usuario> processListRequest(HttpServletRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'processListRequest'");
    }

    @Override
    public Usuario processFormRequest(HttpServletRequest request, HttpServletResponse response) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'processFormRequest'");
    }
    
}
