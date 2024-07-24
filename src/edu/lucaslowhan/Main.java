package edu.lucaslowhan;

public class Main {
    public static void main(String[] args) {

        Cliente lucas = new Cliente();
        lucas.setNome("Lucas Lowhan Gomes Silvestre");
        lucas.setCpf("00000000000");

        Conta cc = new ContaCorrente(lucas);
        Conta cp = new ContaPoupanca(lucas);

        cc.depositar(1000);
        cc.imprimirExtrato();

        cp.depositar(1500);
        cp.transferir(1000,cc);

        cc.imprimirExtrato();
        cp.imprimirExtrato();

        cc.sacar(1000);


    }
}
