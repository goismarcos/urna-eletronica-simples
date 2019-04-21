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
import model.dao.CandidatoDAO;
import model.dao.CargoDAO;
import model.dao.PartidoDAO;
/**
 *
 * @author Marcos
 */
public class Candidato_view extends javax.swing.JFrame 
{
    //METODO CONSTRUTOR
    public Candidato_view() 
    {
        //INICIALIZADOR
        initComponents();
        
        //MUDANDO A COR DE FUNDO DO FORM 
        getContentPane().setBackground(Color.DARK_GRAY);
        
        //INSTANCIANDO A CLASSE PARTIDODAO E CARGODAO
        PartidoDAO par_dao = new PartidoDAO();
        CargoDAO car_dao = new CargoDAO();
        
        //ADICIONANDO PARTIDOS CADASTRADOS NO COMBO BOX
        par_dao.Mostrar_partidos().forEach((p) -> 
        {
            cb_partido.addItem(p);
        });
        
        //ADICIONANDO CARGOS CADASTRADOS NO COMBO BOX
        car_dao.Mostrar_cargos().forEach((c) -> 
        {
            cb_cargo.addItem(c);
        });
        
        //CHAMANDO METODO PARA MOSTRAR OS CANDIDATOS CADASTRADOS
        Mostrar_candidatos();
        
    }
    
    //METODO PARA MOSTRA CANDIDATOS CADASTRADOS
    public void Mostrar_candidatos()
    {
        //INSTANCIANDO O MODELO PARA COMPOR A TABELA
        DefaultTableModel modelo = (DefaultTableModel)  jt_candidatos.getModel();
        modelo.setNumRows(0);
        
        //INSTANCIANDO A CLASSE CANDIDATODAO
        CandidatoDAO cdao = new CandidatoDAO();
        
        //PREENCHENDO A TABELA COM OS CANDIDATOS ATIVOS
        for(model.bean.Candidato c: cdao.Mostrar_candidatos())
        {
            modelo.addRow(new Object[]
            {
               c.getId_candidato(),
               c.getNome(),
               c.getPartido(),
               c.getCargo(),
               c.getNumero()
            });
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btn_desativar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jt_candidatos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        txt_nome_candidato = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cb_cargo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cb_partido = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jf_numero = new javax.swing.JTextField();
        btn_cadastrar = new javax.swing.JButton();
        btn_voltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Candidatos");
        setBackground(new java.awt.Color(0, 102, 0));
        setSize(new java.awt.Dimension(0, 0));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setForeground(new java.awt.Color(51, 51, 51));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Cadastro de candidatos");

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

        btn_desativar.setBackground(new java.awt.Color(51, 51, 51));
        btn_desativar.setForeground(new java.awt.Color(255, 255, 255));
        btn_desativar.setText("Desativar Candidato");
        btn_desativar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_desativarActionPerformed(evt);
            }
        });

        jt_candidatos.setBackground(new java.awt.Color(102, 102, 102));
        jt_candidatos.setForeground(new java.awt.Color(255, 255, 255));
        jt_candidatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Nome", "Partido", "Cargo", "Numero"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jt_candidatos);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txt_nome_candidato.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setText("Nome");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setText("Número");

        cb_cargo.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setText("Partido");

        cb_partido.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setText("Cargo");

        jf_numero.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jf_numero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jf_numeroKeyReleased(evt);
            }
        });

        btn_cadastrar.setBackground(new java.awt.Color(51, 51, 51));
        btn_cadastrar.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        btn_cadastrar.setForeground(new java.awt.Color(255, 255, 255));
        btn_cadastrar.setText("Cadastrar");
        btn_cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cadastrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_nome_candidato)
                    .addComponent(cb_partido, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_cargo, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jf_numero, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3))
                        .addGap(0, 289, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(88, Short.MAX_VALUE)
                    .addComponent(btn_cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(80, 80, 80)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_nome_candidato, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_partido, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_cargo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jf_numero, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(139, 139, 139))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(372, Short.MAX_VALUE)
                    .addComponent(btn_cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(31, 31, 31)))
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
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_voltar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btn_desativar)))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_desativar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btn_voltar)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_voltarActionPerformed
        
        //FECHAR A TELA DE CADASTRO DE CANDIDATOS
        setVisible(false);  
        
        //INSTANCIANDO FORM DA CENTRAL ADM
        Central_adm_view central = new Central_adm_view();
        
        //DEIXANDO A CENTRAL ADM VISIVEL
        central.setVisible(true);
        
    }//GEN-LAST:event_btn_voltarActionPerformed

    private void btn_desativarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_desativarActionPerformed
        
        //SE ESTIVER ALGUM CANDIDATO SELECIONADO
        if(jt_candidatos.getSelectedRow() != -1)
        {
            //INSTANCIANDO A CLASSE CANDIDATO E CANDIDATODAO
            Candidato can = new Candidato();
            CandidatoDAO dao = new CandidatoDAO();
            
            //PEGANDO O ID DO CANDIDATO
            can.setId_candidato((int) jt_candidatos.getValueAt(jt_candidatos.getSelectedRow(), 0));
            
            //DESATIVANDO O CANDIDATO
            dao.Desativar_candidato(can);
            
            //ATUALIZANDO A TABELA DE CANDIDATOS ATIVOS
            Mostrar_candidatos();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Selecione um candidato para ser desativado!");
        }
        
    }//GEN-LAST:event_btn_desativarActionPerformed

    private void jf_numeroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jf_numeroKeyReleased
        
        //FAZENDO COM QUE O CAMPO RECEBA APENAS NUMEROS
        jf_numero.setText(jf_numero.getText().replaceAll("[^1-9]", ""));
        
    }//GEN-LAST:event_jf_numeroKeyReleased

    private void btn_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cadastrarActionPerformed
        
        try
        {
            //INSTANCIANDO A CLASSE CANDIDATOS E CANDIDATODAO
            Candidato can = new Candidato();
            CandidatoDAO dao = new CandidatoDAO();
            
            //PEGANDO OS ITENS DO OBJETO PERTENCENTE AO ITEM SELECIONADO (PARTIDO E CARGO)
            Partido par = (Partido) cb_partido.getSelectedItem();
            Cargo car = (Cargo) cb_cargo.getSelectedItem();
            
            //SETANDO OS VALORES NO OBJETO CANDIDATO
            can.setNome(txt_nome_candidato.getText().toUpperCase());
            can.setId_partido(par.getId_partido());
            can.setId_cargo(car.getId_cargo());
            can.setNumero(Integer.parseInt(jf_numero.getText()));
            
            //CADASTRANDO O NOVO CANDIDATO
            dao.Cadastrar_candidato(can);
            
            //ATUALIZANDO TABELA DE CANDIDATOS ATIVOS
            Mostrar_candidatos();
            
            jf_numero.setText(" ");
            txt_nome_candidato.setText(" ");
            
        }
        catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar candidato!");
        }
    }//GEN-LAST:event_btn_cadastrarActionPerformed

    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cadastrar;
    private javax.swing.JButton btn_desativar;
    private javax.swing.JButton btn_voltar;
    private javax.swing.JComboBox<Object> cb_cargo;
    private javax.swing.JComboBox<Object> cb_partido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jf_numero;
    private javax.swing.JTable jt_candidatos;
    private javax.swing.JTextField txt_nome_candidato;
    // End of variables declaration//GEN-END:variables

}