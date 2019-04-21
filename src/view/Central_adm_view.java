package view;

import java.awt.Color;
import javax.swing.JOptionPane;
import model.dao.CandidatoDAO;
import model.dao.EleitorDAO;
import model.dao.VotoDAO;

/**
 *
 * @author Marcos
 */
public class Central_adm_view extends javax.swing.JFrame 
{
    //METODO CONSTRUTOR
    public Central_adm_view() 
    {
        //INICIALIZADOR
        initComponents();
        
        //MUDANDO A COR DE FUNDO DO FORM 
        getContentPane().setBackground(Color.DARK_GRAY);
        
        //INSTANCIANDO A CLASSE VOTODAO
        VotoDAO voto_dao = new VotoDAO();
        
        //SE OUVER VOTAÇÃO NAO É POSSIVEL CADASTRAR CANDIDATO, ELEITOR E PARTIDO
        if(voto_dao.Verifica_votos() > 0)
        {
            btn_cadastrar_candidato.setEnabled(false);
            btn_cadastrar_partido.setEnabled(false);
            btn_cadastrar_eleitor.setEnabled(false);
        }
        //SE NAO OUVER VOTOS NAO É POSSIVEL TIRAR RELATORIO DE VOTOS
        else
        {
            btn_relatorio.setEnabled(false);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_relatorio = new javax.swing.JButton();
        btn_cadastrar_eleitor = new javax.swing.JButton();
        btn_cadastrar_partido = new javax.swing.JButton();
        btn_cadastrar_candidato = new javax.swing.JButton();
        btn_voltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Central administrativa");

        btn_relatorio.setBackground(new java.awt.Color(51, 51, 51));
        btn_relatorio.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btn_relatorio.setForeground(new java.awt.Color(255, 255, 255));
        btn_relatorio.setText("Relatório / Transmissão");
        btn_relatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_relatorioActionPerformed(evt);
            }
        });

        btn_cadastrar_eleitor.setBackground(new java.awt.Color(51, 51, 51));
        btn_cadastrar_eleitor.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        btn_cadastrar_eleitor.setForeground(new java.awt.Color(255, 255, 255));
        btn_cadastrar_eleitor.setText("Gerar eleitor");
        btn_cadastrar_eleitor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cadastrar_eleitorActionPerformed(evt);
            }
        });

        btn_cadastrar_partido.setBackground(new java.awt.Color(51, 51, 51));
        btn_cadastrar_partido.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        btn_cadastrar_partido.setForeground(new java.awt.Color(255, 255, 255));
        btn_cadastrar_partido.setText("Cadastrar Partido");
        btn_cadastrar_partido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cadastrar_partidoActionPerformed(evt);
            }
        });

        btn_cadastrar_candidato.setBackground(new java.awt.Color(51, 51, 51));
        btn_cadastrar_candidato.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        btn_cadastrar_candidato.setForeground(new java.awt.Color(255, 255, 255));
        btn_cadastrar_candidato.setText("Cadastrar Candidato");
        btn_cadastrar_candidato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cadastrar_candidatoActionPerformed(evt);
            }
        });

        btn_voltar.setBackground(new java.awt.Color(51, 51, 51));
        btn_voltar.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        btn_voltar.setForeground(new java.awt.Color(255, 255, 255));
        btn_voltar.setText("Voltar");
        btn_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_voltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(203, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_cadastrar_eleitor, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_relatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cadastrar_partido, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cadastrar_candidato, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(178, 178, 178))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_voltar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(btn_cadastrar_eleitor, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_cadastrar_candidato, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(btn_cadastrar_partido, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_relatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(btn_voltar)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_relatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_relatorioActionPerformed
        
        //INSTANCIANDO A CLASSE RELATORIO_VIEW E DEIXANDO VISIVEL
        Relatorio_view r = new Relatorio_view();
        r.setVisible(true);
        
        //FECHANDO CENTRAL ADM
        setVisible(false);
    }//GEN-LAST:event_btn_relatorioActionPerformed

    private void btn_cadastrar_eleitorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cadastrar_eleitorActionPerformed
        
        //INSTANCIANDO A CLASSE ELEITORDAO E GERANDO UM NUMERO PARA O ELEITOR
        EleitorDAO eleitor = new EleitorDAO();
        eleitor.Gerar_eleitor();
    }//GEN-LAST:event_btn_cadastrar_eleitorActionPerformed

    private void btn_cadastrar_partidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cadastrar_partidoActionPerformed
        
        //INSTANCIANDO A CLASSE PARTIDO_VIEW E DEIXANDO VISIVEL
        Partido_view p = new Partido_view();
        p.setVisible(true);
        
        //FECHANDO CENTRAL ADM
        setVisible(false);
    }//GEN-LAST:event_btn_cadastrar_partidoActionPerformed

    private void btn_cadastrar_candidatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cadastrar_candidatoActionPerformed
        
        //INSTANCIANDO A CLASSE CANDIDATO_VIEW E DEIXANDO VISIVEL
        Candidato_view c = new Candidato_view();
        c.setVisible(true);
        
        //FECHANDO CENTRAL ADM
        setVisible(false);
    }//GEN-LAST:event_btn_cadastrar_candidatoActionPerformed

    private void btn_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_voltarActionPerformed

        //FECHAR A TELA DE ADM
        setVisible(false);

        //INSTANCIANDO FORM DE INICIO
        Inicio_view inicio = new Inicio_view();

        //DEIXANDO O INICIO VISIVEL
        inicio.setVisible(true);
    }//GEN-LAST:event_btn_voltarActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cadastrar_candidato;
    private javax.swing.JButton btn_cadastrar_eleitor;
    private javax.swing.JButton btn_cadastrar_partido;
    private javax.swing.JButton btn_relatorio;
    private javax.swing.JButton btn_voltar;
    // End of variables declaration//GEN-END:variables
}
