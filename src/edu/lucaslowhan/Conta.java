package edu.lucaslowhan;

public abstract class Conta implements IConta {
    private static int SEQUENCIAL = 1;
    protected static final int AGENCIA_PADRAO = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente){
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }


    @Override
    public void depositar(double valor) {
        if(valor < 0 ){
            System.out.println("Valor incorreto!");
        }
        else {
            saldo += valor;
        }
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        if(valor <= this.saldo){
        this.sacar(valor);
        contaDestino.depositar(valor);
        }
        else if(valor < 0 ){
            System.out.println("Valor incorreto!");
        }
        else{
            System.out.println("Saldo insuficiente!");
        }
    }

    @Override
    public void sacar(double valor) {
        if (valor <= this.saldo) {
            saldo -= valor;
        }
        else if(valor < 0 ){
            System.out.println("Valor incorreto!");
        }
        else{
            System.out.println("Saldo insuficiente!");
        }
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void imprimirInfos(){
        System.out.println(String.format("Titular: %s",this.cliente.getNome()));
        System.out.println(String.format("CPF: %s",this.cliente.getCpf()));
        System.out.println(String.format("Agencia: %d",this.agencia));
        System.out.println(String.format("Numero: %d",this.numero));
        System.out.println(String.format("Saldo: %2f",this.saldo));
    }
}
