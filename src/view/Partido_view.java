package view;


import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.dao.CandidatoDAO;
import model.dao.CargoDAO;
import model.dao.PartidoDAO;
import model.bean.Candidato;
import model.bean.Cargo;
import model.bean.Partido;
/**
 *
 * @author Marcos
 */
public class Partido_view extends javax.swing.JFrame 
{
    //METODO CONSTRUTOR
    public Partido_view() 
    {
        //INICIALIZADOR
        initComponents();
        
        //MUDANDO A COR DE FUNDO DO FORM 
        getContentPane().setBackground(Color.DARK_GRAY);
          
        //CHAMANDO METODO PARA MOSTRAR OS PARTIDOS CADASTRADOS
        Mostrar_partidos();
        
    }
    
    //METODO PARA MOSTRA PARTIDOS CADASTRADOS
    public void Mostrar_partidos()
    {
        //INSTANCIANDO O MODELO PARA COMPOR A TABELA
        DefaultTableModel modelo = (DefaultTableModel)  jt_partidos.getModel();
        modelo.setNumRows(0);
        
        //INSTANCIANDO A CLASSE CANDIDATODAO
        PartidoDAO cdao = new PartidoDAO();
        
        //PREENCHENDO A TABELA COM OS PARTIDOS ATIVOS
        for(model.bean.Partido p: cdao.Mostrar_partidos())
        {
            modelo.addRow(new Object[]{
               p.getId_partido(),
               p.getNome()
            });
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btn_desativar_partido = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jt_partidos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btn_cadastrar_partido = new javax.swing.JButton();
        txt_nome_partido = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btn_voltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Partidos");
        setBackground(new java.awt.Color(0, 102, 0));
        setSize(new java.awt.Dimension(0, 0));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setForeground(new java.awt.Color(51, 51, 51));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Cadastro de partidos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(141, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(118, 118, 118))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                .addContainerGap())
        );

        btn_desativar_partido.setBackground(new java.awt.Color(51, 51, 51));
        btn_desativar_partido.setForeground(new java.awt.Color(255, 255, 255));
        btn_desativar_partido.setText("Desativar Partido");
        btn_desativar_partido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_desativar_partidoActionPerformed(evt);
            }
        });

        jt_partidos.setBackground(new java.awt.Color(102, 102, 102));
        jt_partidos.setForeground(new java.awt.Color(255, 255, 255));
        jt_partidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Código", "Nome"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jt_partidos);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btn_cadastrar_partido.setBackground(new java.awt.Color(51, 51, 51));
        btn_cadastrar_partido.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        btn_cadastrar_partido.setForeground(new java.awt.Color(255, 255, 255));
        btn_cadastrar_partido.setText("Cadastrar");
        btn_cadastrar_partido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cadastrar_partidoActionPerformed(evt);
            }
        });

        txt_nome_partido.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setText("Sigla");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_nome_partido)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 312, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(btn_cadastrar_partido, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_nome_partido, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 234, Short.MAX_VALUE)
                .addComponent(btn_cadastrar_partido, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_desativar_partido)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(btn_voltar)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_desativar_partido, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btn_voltar)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cadastrar_partidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cadastrar_partidoActionPerformed
        
        try
        {
            //INSTANCIANDO A CLASSE PARTIDO E PARTIDODAO
            Partido par = new Partido();
            PartidoDAO dao = new PartidoDAO();
            
            //SETANDO OS VALORES NO OBJETO PARTIDO
            par.setNome(txt_nome_partido.getText().toUpperCase());
            
            //CADASTRANDO O NOVO PARTIDO
            dao.Cadastrar_partido(par);
            
            //ATUALIZANDO TABELA DE PARTIDOS ATIVOS
            Mostrar_partidos();
            
            txt_nome_partido.setText(" ");
            
        }
        catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar partido!");
        }
        
        
    }//GEN-LAST:event_btn_cadastrar_partidoActionPerformed

    private void btn_desativar_partidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_desativar_partidoActionPerformed
        
        //SE ESTIVER ALGUM PARTIDO SELECIONADO
        if(jt_partidos.getSelectedRow() != -1)
        {
            //INSTANCIANDO A CLASSE PARTIDO E PARTIDODAO
            Partido par = new Partido();
            PartidoDAO dao = new PartidoDAO();
            
            //PEGANDO O ID DO CANDIDATO
            par.setId_partido((int) jt_partidos.getValueAt(jt_partidos.getSelectedRow(), 0));
            
            //DESATIVANDO O CANDIDATO
            dao.Desativar_partido(par);
            
            //ATUALIZANDO A TABELA DE CANDIDATOS ATIVOS
            Mostrar_partidos();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Selecione um partido para ser desativado!");
        }
        
    }//GEN-LAST:event_btn_desativar_partidoActionPerformed

    private void btn_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_voltarActionPerformed

        //FECHAR A TELA DE CADASTRO DE CANDIDATOS
        setVisible(false);
        
        //INSTANCIANDO FORM DA CENTRAL ADM
        Central_adm_view central = new Central_adm_view();
        
        //DEIXANDO A CENTRAL ADM VISIVEL
        central.setVisible(true);

    }//GEN-LAST:event_btn_voltarActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cadastrar_partido;
    private javax.swing.JButton btn_desativar_partido;
    private javax.swing.JButton btn_voltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jt_partidos;
    private javax.swing.JTextField txt_nome_partido;
    // End of variables declaration//GEN-END:variables

}