package amc.scda.dao;

import java.util.List;

import amc.scda.entity.Divida;

public interface DividaDAO {
	
	public List<Divida> listaTodasDividas();
	
	public List<Divida> dividasNaoPagas();
	
	public List<Divida> dividasEmRecurso();
	
	public List<Divida> dividasLiquidadas();
	
	public List<Divida> dividasExecutadas();
	
	public List<Divida> dividasPrescritas();
	
	public List<Divida> buscaPorStatus();
	
	public List<Divida> buspaPorId();

}
