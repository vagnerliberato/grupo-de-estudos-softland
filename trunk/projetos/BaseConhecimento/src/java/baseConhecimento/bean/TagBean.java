package baseConhecimento.bean;

public class TagBean {
    
    private int Id_Tag;
    private String Nome;

    public TagBean() {
        this.Id_Tag = 0;
        this.Nome = null;
    }   
    
    public int getId_Tag() {
        return Id_Tag;
    }

    public void setId_Tag(int Id_Tag) {
        this.Id_Tag = Id_Tag;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }
}
