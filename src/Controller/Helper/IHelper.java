/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Interfaces/Interface.java to edit this template
 */
package Controller.Helper;

/**
 * Contrato que todo Helper do projeto deve seguir.
 * Obriga cada Helper a saber obter o modelo da tela e limpar os campos.
 */
public interface IHelper {

    public Object obterModelo();

    public void limparTela();
}
