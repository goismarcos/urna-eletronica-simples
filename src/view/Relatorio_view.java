package view;

import java.awt.Color;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.dao.CandidatoDAO;
import model.dao.CargoDAO;
import model.dao.PartidoDAO;
import model.dao.VotoDAO;
import model.bean.Candidato;
import model.bean.Cargo;
import model.bean.Partido;
/**
 *
 * @author Marcos
 */
public class Relatorio_view extends javax.swing.JFrame 
{
    //METODO CONSTRUTOR
    public Relatorio_view() 
    {
        //INICIALIZADOR
        initComponents();
        
        //MUDANDO A COR DE FUNDO DO FORM 
        getContentPane().setBackground(Color.DARK_GRAY);
        
        //INSTANCIANDO A CLASSE CARGODAO
        CargoDAO car_dao = new CargoDAO();
        
        //ADICIONANDO CARGOS CADASTRADOS NO COMBO BOX
        car_dao.Mostrar_cargos().forEach((c) -> 
        {
            cb_cargo.addItem(c);
        });
    }
    
    //METODO PARA MOSTRAR RELATORIOS DA VOTAÇÃO
    public void Mostrar_relatorio()
    {
        //INSTANCIANDO O MODELO PARA COMPOR A TABELA
        DefaultTableModel modelo = (DefaultTableModel)  jt_relatorio.getModel();
        modelo.setNumRows(0);
        
        //INSTANCIANDO A CLASSE VOTODAO
        VotoDAO vdao = new VotoDAO();
        
        //PEGANDO ID DO CARGO PARA GERAR O RELATORIO
        Cargo car = (Cargo) cb_cargo.getSelectedItem();
        
        //PREENCHENDO A TABELA COM RELATORIO DAQUELE CARGO
        for(model.bean.Voto v: vdao.Mostrar_relatorio(car) )
        {
            modelo.addRow(new Object[]{
               v.getTotal_votos(),
               v.getNome()
            });
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jt_relatorio = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btn_transmitir_dados = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cb_cargo = new javax.swing.JComboBox<>();
        btn_pesquisar = new javax.swing.JButton();
        btn_voltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Relatórios de votos");
        setBackground(new java.awt.Color(0, 102, 0));
        setSize(new java.awt.Dimension(0, 0));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setForeground(new java.awt.Color(51, 51, 51));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Relatórios de votos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(178, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                .addContainerGap())
        );

        jt_relatorio.setBackground(new java.awt.Color(102, 102, 102));
        jt_relatorio.setForeground(new java.awt.Color(255, 255, 255));
        jt_relatorio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Total de votos", "Candidato"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jt_relatorio);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btn_transmitir_dados.setBackground(new java.awt.Color(51, 51, 51));
        btn_transmitir_dados.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        btn_transmitir_dados.setForeground(new java.awt.Color(255, 255, 255));
        btn_transmitir_dados.setText("Transmitir Dados");
        btn_transmitir_dados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_transmitir_dadosActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setText("Cargo");

        cb_cargo.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        btn_pesquisar.setBackground(new java.awt.Color(51, 51, 51));
        btn_pesquisar.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        btn_pesquisar.setForeground(new java.awt.Color(255, 255, 255));
        btn_pesquisar.setText("Pesquisar");
        btn_pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 303, Short.MAX_VALUE))
                    .addComponent(cb_cargo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_transmitir_dados, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(98, Short.MAX_VALUE)
                    .addComponent(btn_pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(70, 70, 70)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_cargo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_transmitir_dados, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(203, Short.MAX_VALUE)
                    .addComponent(btn_pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(183, 183, 183)))
        );

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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btn_voltar))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_voltar)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_transmitir_dadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_transmitir_dadosActionPerformed
       
        try 
        {
            //INSTANCIANDO A CLASSE VOTODAO
            VotoDAO voto = new VotoDAO();
            
            //CHAMANDO METODO PARA TRANSMITIR DADOS PARA UM TXT
            voto.Transmitir_dados();
            
            //APAGANDO REGISTROS DE VOTOS E CANDIDATOS
            voto.Apagar_registros();
            
            //DESABILITANDO BOTOES 
            btn_transmitir_dados.setEnabled(false);
            btn_pesquisar.setEnabled(false);
            cb_cargo.setEnabled(false);
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Relatorio_view.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btn_transmitir_dadosActionPerformed

    private void btn_pesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pesquisarActionPerformed
        
        try
        {
            //MOSTRANDO RELATORIO DE VOTOS
            Mostrar_relatorio();
        }
        catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar candidato!");
        }
    }//GEN-LAST:event_btn_pesquisarActionPerformed

    private void btn_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_voltarActionPerformed

        //FECHAR A TELA DE RELATORIO DE VOTOS
        setVisible(false);
        
        //INSTANCIANDO FORM DA CENTRAL ADM
        Central_adm_view central = new Central_adm_view();
        
        //DEIXANDO A CENTRAL ADM VISIVEL
        central.setVisible(true);
    }//GEN-LAST:event_btn_voltarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_pesquisar;
    private javax.swing.JButton btn_transmitir_dados;
    private javax.swing.JButton btn_voltar;
    private javax.swing.JComboBox<Object> cb_cargo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jt_relatorio;
    // End of variables declaration//GEN-END:variables

}