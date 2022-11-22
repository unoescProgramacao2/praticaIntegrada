CREATE OR REPLACE FUNCTION comandasEmAberto()
RETURNS TABLE (id BIGINT, data_abertura TIMESTAMP, mesa_id BIGINT, valor FLOAT, empresa_id BIGINT, funcionario_id BIGINT) AS $$
BEGIN
    RETURN QUERY
        SELECT c.id, c.data_abertura, c.mesa_id, c.valor, c.empresa_id, c.funcionario_id
        FROM comandas c
        WHERE c.data_fechamento IS NULL;
    RETURN;
END;
$$ LANGUAGE plpgsql;

select comandasEmAberto();


CREATE OR REPLACE FUNCTION valorComandasAbertoEmpresa(empresa_id_p BIGINT)
RETURNS FLOAT AS $$
DECLARE valor FLOAT;
BEGIN
    SELECT SUM(c.valor) INTO valor
    FROM comandas c
    WHERE c.data_fechamento IS NULL
    AND c.empresa_id = empresa_id_p;
    RETURN valor;
END;
$$ LANGUAGE plpgsql;

select valorComandasAbertoEmpresa(1);

CREATE OR REPLACE FUNCTION produtosMaisVendidos()
RETURNS TABLE (quantidade BIGINT, nome VARCHAR ) AS $$
BEGIN
    RETURN QUERY
      select sum(o.quantidade) as quantidade, i.nome 
        from ordens o join itens i on o.item_id = i.id
        join comandas c on o.comanda_id = c.id 
        group by i.nome
        order by sum(o.quantidade) desc;  
    RETURN;
END;
$$ LANGUAGE plpgsql;

select produtosMaisVendidos();

CREATE INDEX IF NOT EXISTS idx_item_descricao_valor ON itens USING btree (id, descricao, valor ASC);

CREATE INDEX IF NOT EXISTS idx_ordem_quantidade_itemId_valor ON ordens USING btree (id, quantidade, item_id, valor);

CREATE INDEX IF NOT EXISTS idx_empresa ON empresas USING hash (id);

CREATE INDEX IF NOT EXISTS idx_comanda ON comandas USING btree (id);