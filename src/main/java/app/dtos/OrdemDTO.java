package app.dtos;

import app.entities.Ordem;

public class OrdemDTO {

    private Long id;

    private Long comandaId;

    private Long itemId;

    private int quantidade;

    public OrdemDTO() {
        super();
    }

    public OrdemDTO(Ordem ordem) {
        super();
        if (ordem.getId() != null)
            this.id = ordem.getId();

        this.id = ordem.getId();
        this.comandaId = ordem.getComanda().getId();
        this.itemId = ordem.getItem().getId();
        this.quantidade = ordem.getQuantidade();
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getComandaId() {
        return comandaId;
    }

    public void setComandaId(long comandaId) {
        this.comandaId = comandaId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

}
