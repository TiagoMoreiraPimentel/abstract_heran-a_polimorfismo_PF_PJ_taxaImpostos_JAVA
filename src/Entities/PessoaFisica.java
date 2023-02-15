package Entities;

public class PessoaFisica extends Pessoa {
	
	private Double gastoSaude;
	
	public PessoaFisica() {
		super();
	}

	public PessoaFisica(String nome, Double rendaAnual, Double gastoSaude) {
		super(nome, rendaAnual);
		this.gastoSaude = gastoSaude;
	}

	public Double getGastoSaude() {
		return gastoSaude;
	}

	public void setGastoSaude(Double gastoSaude) {
		this.gastoSaude = gastoSaude;
	}

	@Override
	public Double CalculoImposto() {
		
		if(getRendaAnual() < 20000.00) {
			return getRendaAnual() * 0.15 - gastoSaude * 0.5;
		}
		else {
			return getRendaAnual() * 0.25 - gastoSaude * 0.5;
		}	
	}
}
