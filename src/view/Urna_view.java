package view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.Candidato;
import model.bean.Eleitor;
import model.bean.Voto;
import model.dao.EleitorDAO;
import model.dao.VotoDAO;

public class Urna_view extends javax.swing.JFrame 
{
    //METODO CONSTRUTOR
    public Urna_view() 
    {
        //INICIALIZADOR
        initComponents();
        //INICIALIZANDO OS LABELS E TEXTFIELD
        jt_1.setText(" ");
        jt_2.setText(" ");
        jt_3.setText(" ");
        jt_4.setText(" ");
        jt_5.setText(" ");
        lbl_nome_candidato.setText("NENHUM");
        lbl_partido.setText("NENHUM");
        jt_1.setEnabled(false);
        jt_2.setEnabled(false);
        jt_3.setEnabled(false);
        jt_4.setEnabled(false);
        jt_5.setEnabled(false);  
        btn_votar.setVisible(false);
        btn_voltar.setVisible(false);
    }
    
    //METODO PARA MOSTRA CANDIDATOS DIGITADO
    public void Mostrar_candidato()
    {
        //SE O QUINTO DIGITO FOR DIGITADO E O LABEL FOR DEPUTADO FEDERAL
        if(jt_5.getText() != " " && lbl_cargo.getText() == "DEPUTADO FEDERAL")
        {
            //PEGANDO O NUMERO DIGITADO
            int num = Integer.parseInt(jt_1.getText()+jt_2.getText()+jt_3.getText()+jt_4.getText()+jt_5.getText());
            
            //INSTANCIANDO A CLASSE CANDIDATO E VOTODAO
            VotoDAO voto_dao = new VotoDAO();
            Candidato can = new Candidato();
            
            //SETANDO O NUMERO DIGITADO NO OBJETO CANDIDATO
            can.setNumero(num);
            can.setId_cargo(2);
            
            //PREENCHENDO O LABEL COM O CANDIDATO CADASTRADO
            for(model.bean.Candidato c: voto_dao.Buscar_candidato(can))
            {
                lbl_nome_candidato.setText(c.getNome());
                lbl_partido.setText(c.getPartido());
            }
        }
        //SE O QUARTO DIGITO FOR DIGITADO E O LABEL FOR DEPUTADO ESTADUAL
        else if(jt_4.getText() != " " && lbl_cargo.getText() == "DEPUTADO ESTADUAL")
        {
            //PEGANDO O NUMERO DIGITADO
            int num = Integer.parseInt(jt_1.getText()+jt_2.getText()+jt_3.getText()+jt_4.getText());
            
            //INSTANCIANDO A CLASSE CANDIDATO E VOTODAO
            VotoDAO voto_dao = new VotoDAO();
            Candidato can = new Candidato();
            
            //SETANDO O NUMERO DIGITADO NO OBJETO CANDIDATO
            can.setNumero(num);
            can.setId_cargo(1);

            //PREENCHENDO O LABEL COM O CANDIDATO CADASTRADO
            for(model.bean.Candidato c: voto_dao.Buscar_candidato(can))
            {
                lbl_nome_candidato.setText(c.getNome());
                lbl_partido.setText(c.getPartido());
            }
            
        }
        //SE O TERCEIRO DIGITO FOR DIGITADO E O LABEL FOR SENADOR
        else if(jt_3.getText() != " " && lbl_cargo.getText() == "SENADOR")
        {
            //PEGANDO O NUMERO DIGITADO
            int num = Integer.parseInt(jt_1.getText()+jt_2.getText()+jt_3.getText());
            
            //INSTANCIANDO A CLASSE CANDIDATO E VOTODAO
            VotoDAO voto_dao = new VotoDAO();
            Candidato can = new Candidato();
            
            //SETANDO O NUMERO DIGITADO NO OBJETO CANDIDATO
            can.setNumero(num);
            can.setId_cargo(3);

            //PREENCHENDO O LABEL COM O CANDIDATO CADASTRADO
            for(model.bean.Candidato c: voto_dao.Buscar_candidato(can))
            {
                lbl_nome_candidato.setText(c.getNome());
                lbl_partido.setText(c.getPartido());
            }
            
        }
        //SE O SEGUNDO DIGITO FOR DIGITADO E O LABEL FOR GOVERNADOR OU PRESIDENTE
        else if(jt_2.getText() != " " && (lbl_cargo.getText() == "GOVERNADOR"))
        {
            //PEGANDO O NUMERO DIGITADO
            int num = Integer.parseInt(jt_1.getText()+jt_2.getText());
            
            //INSTANCIANDO A CLASSE CANDIDATO E VOTODAO
            VotoDAO voto_dao = new VotoDAO();
            Candidato can = new Candidato();
            
            //SETANDO O NUMERO DIGITADO NO OBJETO CANDIDATO
            can.setNumero(num);
            can.setId_cargo(4);

            //PREENCHENDO O LABEL COM O CANDIDATO CADASTRADO
            for(model.bean.Candidato c: voto_dao.Buscar_candidato(can))
            {
                lbl_nome_candidato.setText(c.getNome());
                lbl_partido.setText(c.getPartido());
            }
        }
        else if(jt_2.getText() != " " &&  lbl_cargo.getText() == "PRESIDENTE")
        {
            //PEGANDO O NUMERO DIGITADO
            int num = Integer.parseInt(jt_1.getText()+jt_2.getText());
            
            //INSTANCIANDO A CLASSE CANDIDATO E VOTODAO
            VotoDAO voto_dao = new VotoDAO();
            Candidato can = new Candidato();
            
            //SETANDO O NUMERO DIGITADO NO OBJETO CANDIDATO
            can.setNumero(num);
            can.setId_cargo(5);

            //PREENCHENDO O LABEL COM O CANDIDATO CADASTRADO
            for(model.bean.Candidato c: voto_dao.Buscar_candidato(can))
            {
                lbl_nome_candidato.setText(c.getNome());
                lbl_partido.setText(c.getPartido());
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_nome_partido = new javax.swing.JPanel();
        lbl_seu_voto = new javax.swing.JLabel();
        lbl_num = new javax.swing.JLabel();
        lbl_nome = new javax.swing.JLabel();
        lbl_par = new javax.swing.JLabel();
        lbl_cargo = new javax.swing.JLabel();
        lbl_nome_candidato = new javax.swing.JLabel();
        lbl_partido = new javax.swing.JLabel();
        jt_1 = new javax.swing.JTextField();
        jt_2 = new javax.swing.JTextField();
        jt_3 = new javax.swing.JTextField();
        jt_4 = new javax.swing.JTextField();
        jt_5 = new javax.swing.JTextField();
        lbl_fim = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btn_1 = new javax.swing.JButton();
        btn_2 = new javax.swing.JButton();
        btn_3 = new javax.swing.JButton();
        btn_4 = new javax.swing.JButton();
        btn_5 = new javax.swing.JButton();
        btn_6 = new javax.swing.JButton();
        btn_7 = new javax.swing.JButton();
        btn_8 = new javax.swing.JButton();
        btn_9 = new javax.swing.JButton();
        btn_0 = new javax.swing.JButton();
        btn_branco = new javax.swing.JButton();
        btn_corrige = new javax.swing.JButton();
        btn_confirma = new javax.swing.JButton();
        btn_voltar = new javax.swing.JButton();
        btn_votar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Urna de votação");
        setResizable(false);

        lbl_nome_partido.setBackground(new java.awt.Color(204, 204, 204));

        lbl_seu_voto.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_seu_voto.setText("SEU VOTO PARA");

        lbl_num.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_num.setText("Número:");

        lbl_nome.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_nome.setText("Candidato:");

        lbl_par.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_par.setText("Partido:");

        lbl_cargo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbl_cargo.setText("DEPUTADO FEDERAL");

        lbl_nome_candidato.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_nome_candidato.setText("Candidato");

        lbl_partido.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_partido.setText("Partido");

        jt_1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        jt_2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        jt_3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        jt_4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        jt_5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jt_5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jt_5KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jt_5KeyTyped(evt);
            }
        });

        lbl_fim.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        javax.swing.GroupLayout lbl_nome_partidoLayout = new javax.swing.GroupLayout(lbl_nome_partido);
        lbl_nome_partido.setLayout(lbl_nome_partidoLayout);
        lbl_nome_partidoLayout.setHorizontalGroup(
            lbl_nome_partidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbl_nome_partidoLayout.createSequentialGroup()
                .addGroup(lbl_nome_partidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lbl_nome_partidoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(lbl_nome_partidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_seu_voto)
                            .addGroup(lbl_nome_partidoLayout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(lbl_nome_partidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(lbl_nome_partidoLayout.createSequentialGroup()
                                        .addComponent(lbl_par)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lbl_partido))
                                    .addGroup(lbl_nome_partidoLayout.createSequentialGroup()
                                        .addComponent(lbl_num)
                                        .addGap(18, 18, 18)
                                        .addComponent(jt_1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jt_2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jt_3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jt_4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jt_5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(lbl_nome_partidoLayout.createSequentialGroup()
                                        .addComponent(lbl_nome)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbl_nome_candidato))))))
                    .addGroup(lbl_nome_partidoLayout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(lbl_cargo, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(lbl_nome_partidoLayout.createSequentialGroup()
                        .addGap(338, 338, 338)
                        .addComponent(lbl_fim, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(305, Short.MAX_VALUE))
        );
        lbl_nome_partidoLayout.setVerticalGroup(
            lbl_nome_partidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbl_nome_partidoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_seu_voto)
                .addGap(36, 36, 36)
                .addComponent(lbl_cargo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addGroup(lbl_nome_partidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jt_1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jt_2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jt_3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jt_4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jt_5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_num))
                .addGap(11, 11, 11)
                .addComponent(lbl_fim, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(lbl_nome_partidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_nome)
                    .addComponent(lbl_nome_candidato))
                .addGap(61, 61, 61)
                .addGroup(lbl_nome_partidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_par)
                    .addComponent(lbl_partido))
                .addGap(81, 81, 81))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/img.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("JUSTIÇA");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("ELEITORAL");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel7))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        btn_1.setBackground(new java.awt.Color(0, 0, 0));
        btn_1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btn_1.setForeground(new java.awt.Color(255, 255, 255));
        btn_1.setText("1");
        btn_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_1ActionPerformed(evt);
            }
        });

        btn_2.setBackground(new java.awt.Color(0, 0, 0));
        btn_2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btn_2.setForeground(new java.awt.Color(255, 255, 255));
        btn_2.setText("2");
        btn_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_2ActionPerformed(evt);
            }
        });

        btn_3.setBackground(new java.awt.Color(0, 0, 0));
        btn_3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btn_3.setForeground(new java.awt.Color(255, 255, 255));
        btn_3.setText("3");
        btn_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_3ActionPerformed(evt);
            }
        });

        btn_4.setBackground(new java.awt.Color(0, 0, 0));
        btn_4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btn_4.setForeground(new java.awt.Color(255, 255, 255));
        btn_4.setText("4");
        btn_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_4ActionPerformed(evt);
            }
        });

        btn_5.setBackground(new java.awt.Color(0, 0, 0));
        btn_5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btn_5.setForeground(new java.awt.Color(255, 255, 255));
        btn_5.setText("5");
        btn_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_5ActionPerformed(evt);
            }
        });

        btn_6.setBackground(new java.awt.Color(0, 0, 0));
        btn_6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btn_6.setForeground(new java.awt.Color(255, 255, 255));
        btn_6.setText("6");
        btn_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_6ActionPerformed(evt);
            }
        });

        btn_7.setBackground(new java.awt.Color(0, 0, 0));
        btn_7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btn_7.setForeground(new java.awt.Color(255, 255, 255));
        btn_7.setText("7");
        btn_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_7ActionPerformed(evt);
            }
        });

        btn_8.setBackground(new java.awt.Color(0, 0, 0));
        btn_8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btn_8.setForeground(new java.awt.Color(255, 255, 255));
        btn_8.setText("8");
        btn_8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_8ActionPerformed(evt);
            }
        });

        btn_9.setBackground(new java.awt.Color(0, 0, 0));
        btn_9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btn_9.setForeground(new java.awt.Color(255, 255, 255));
        btn_9.setText("9");
        btn_9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_9ActionPerformed(evt);
            }
        });

        btn_0.setBackground(new java.awt.Color(0, 0, 0));
        btn_0.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btn_0.setForeground(new java.awt.Color(255, 255, 255));
        btn_0.setText("0");
        btn_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_0ActionPerformed(evt);
            }
        });

        btn_branco.setBackground(new java.awt.Color(255, 255, 255));
        btn_branco.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_branco.setText("BRANCO");
        btn_branco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_brancoActionPerformed(evt);
            }
        });

        btn_corrige.setBackground(new java.awt.Color(255, 102, 0));
        btn_corrige.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_corrige.setText("CORRIGE");
        btn_corrige.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_corrigeActionPerformed(evt);
            }
        });

        btn_confirma.setBackground(new java.awt.Color(0, 204, 0));
        btn_confirma.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_confirma.setText("CONFIRMA");
        btn_confirma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_confirmaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btn_branco)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_corrige, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_confirma, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_4, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_0, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_9, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 8, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_2, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)))
                    .addComponent(btn_1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_4, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(btn_6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_0, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btn_branco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_confirma, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                    .addComponent(btn_corrige, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        btn_voltar.setBackground(new java.awt.Color(51, 51, 51));
        btn_voltar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_voltar.setForeground(new java.awt.Color(255, 255, 255));
        btn_voltar.setText("Voltar");
        btn_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_voltarActionPerformed(evt);
            }
        });

        btn_votar.setBackground(new java.awt.Color(0, 0, 0));
        btn_votar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_votar.setForeground(new java.awt.Color(255, 255, 255));
        btn_votar.setText("Votar");
        btn_votar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_votarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(270, 270, 270)
                        .addComponent(btn_votar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_nome_partido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_nome_partido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_voltar, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(btn_votar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_1ActionPerformed
        
        //VERIFICANDO SE JA TEM NUMERO DIGITADO NO TEXTFIELD CASO NAO TENHA O TEXT FIELD RECEBE O NUMERO
        if(" ".equals(jt_1.getText()))
        {
            jt_1.setText("1");
        }
        else if(" ".equals(jt_2.getText()))
        {
            jt_2.setText("1");
        }
        else if(" ".equals(jt_3.getText()))
        {
            jt_3.setText("1");
        }
        else if(" ".equals(jt_4.getText()))
        {
            jt_4.setText("1");
        }
        else if(" ".equals(jt_5.getText()))
        {
            jt_5.setText("1");
        }
        
        Mostrar_candidato();
    }//GEN-LAST:event_btn_1ActionPerformed

    private void btn_corrigeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_corrigeActionPerformed
        
        //ZERANDO OS LABELS E OS TEXTFIELD
        jt_1.setText(" ");
        jt_2.setText(" ");
        jt_3.setText(" ");
        jt_4.setText(" ");
        jt_5.setText(" ");
        lbl_nome_candidato.setText("NENHUM");
        lbl_partido.setText("NENHUM");
        
    }//GEN-LAST:event_btn_corrigeActionPerformed

    private void btn_confirmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_confirmaActionPerformed
        
        //SE O LABELS FOR IGUAL A DEPUTADO FEDERAL
        if(lbl_cargo.getText() == "DEPUTADO FEDERAL")
        {
            //SE TODOS OS NUMERO PARA DEPUTADO FEDERAL NAO FORAM PREENCHIDOS
            if((" ".equals(jt_1.getText()) || " ".equals(jt_2.getText()) || " ".equals(jt_3.getText()) || " ".equals(jt_4.getText()) || " ".equals(jt_5.getText())))
            {
                JOptionPane.showMessageDialog(null, "Erro: Preencha todos os campos!");
            }
            else
            {
                //PEGANDO O NUMERO DIGITADO
                int num = Integer.parseInt(jt_1.getText()+jt_2.getText()+jt_3.getText()+jt_4.getText()+jt_5.getText());
                
                //INSTANCIANDO A CLASSE VOTODAO E VOTO
                Voto voto = new Voto();
                VotoDAO voto_dao = new VotoDAO();
                
                //SETANDO O NUMERO DO CANDIDATO E PARTIDO
                voto.setNumero(num);
                voto.setId_cargo(2);
                
                //METODO PARA INSERIR O CANDIDATO
                voto_dao.Inserir_votos(voto);
                
                //MUNDANDO O LABELS PARA O PROXIMO CANDIDATO
                lbl_cargo.setText("DEPUTADO ESTADUAL");
                
                //OCULTANDO UM CAMPO PARA O PROXIMO CANDIDATO
                jt_5.setVisible(false);
                
                //ZERANDO OS LABELS E TEXTFIELD
                lbl_nome_candidato.setText("NENHUM");
                lbl_partido.setText("NENHUM");
                jt_1.setText(" ");
                jt_2.setText(" ");
                jt_3.setText(" ");
                jt_4.setText(" ");
            }

        }
        //SE O LABELS FOR IGUAL A DEPUTADO ESTADUAL
        else if(lbl_cargo.getText() == "DEPUTADO ESTADUAL")
        {
            //SE TODOS OS NUMERO PARA DEPUTADO ESTADUAL NAO FORAM PREENCHIDOS
            if((" ".equals(jt_1.getText()) || " ".equals(jt_2.getText()) || " ".equals(jt_3.getText()) || " ".equals(jt_4.getText())))
            {
                JOptionPane.showMessageDialog(null, "Erro: Preencha todos os campos!");
            }
            else
            {
                //PEGANDO O NUMERO DIGITADO
                int num = Integer.parseInt(jt_1.getText()+jt_2.getText()+jt_3.getText()+jt_4.getText());
                
                //INSTANCIANDO A CLASSE VOTODAO E VOTO
                VotoDAO voto_dao = new VotoDAO();
                Voto voto = new Voto();
                
                //SETANDO O NUMERO DO CANDIDATO E PARTIDO
                voto.setNumero(num);
                voto.setId_cargo(1);
                
                //METODO PARA INSERIR O CANDIDATO
                voto_dao.Inserir_votos(voto);
                
                //MUNDANDO O LABELS PARA O PROXIMO CANDIDATO
                lbl_cargo.setText("SENADOR");
                
                //OCULTANDO UM CAMPO PARA O PROXIMO CANDIDATO
                jt_4.setVisible(false);
                
                //ZERANDO OS LABELS E TEXTFIELD
                lbl_nome_candidato.setText("NENHUM");
                lbl_partido.setText("NENHUM");
                jt_1.setText(" ");
                jt_2.setText(" ");
                jt_3.setText(" ");
            }
        }
        //SE O LABELS FOR IGUAL A SENADOR
        else if(lbl_cargo.getText() == "SENADOR")
        {
            //SE TODOS OS NUMERO PARA SENADOR NAO FORAM PREENCHIDOS
            if((" ".equals(jt_1.getText()) || " ".equals(jt_2.getText()) || " ".equals(jt_3.getText())))
            {
                JOptionPane.showMessageDialog(null, "Erro: Preencha todos os campos!");
            }
            else
            {
                //PEGANDO O NUMERO DIGITADO
                int num = Integer.parseInt(jt_1.getText()+jt_2.getText()+jt_3.getText());
                
                //INSTANCIANDO A CLASSE VOTODAO E VOTO
                VotoDAO voto_dao = new VotoDAO();
                Voto voto = new Voto();
                
                
                //SETANDO O NUMERO DO CANDIDATO E PARTIDO
                voto.setNumero(num);
                voto.setId_cargo(3);
                
                //METODO PARA INSERIR O CANDIDATO
                voto_dao.Inserir_votos(voto);
                
                //MUNDANDO O LABELS PARA O PROXIMO CANDIDATO
                lbl_cargo.setText("GOVERNADOR");
                
                //OCULTANDO UM CAMPO PARA O PROXIMO CANDIDATO
                jt_3.setVisible(false);
                
                //ZERANDO OS LABELS E TEXTFIELD
                lbl_nome_candidato.setText("NENHUM");
                lbl_partido.setText("NENHUM");
                jt_1.setText(" ");
                jt_2.setText(" ");
                jt_3.setText(" ");
            }
        }
        //SE O LABELS FOR IGUAL A GOVERNADOR
        else if(lbl_cargo.getText() == "GOVERNADOR")
        {
            //SE TODOS OS NUMERO PARA GOVERNADOR NAO FORAM PREENCHIDOS
            if((" ".equals(jt_1.getText()) || " ".equals(jt_2.getText())))
            {
                JOptionPane.showMessageDialog(null, "Erro: Preencha todos os campos!");
            }
            else
            {
                //PEGANDO O NUMERO DIGITADO
                int num = Integer.parseInt(jt_1.getText()+jt_2.getText());
                
                //INSTANCIANDO A CLASSE VOTODAO E VOTO
                VotoDAO voto_dao = new VotoDAO();
                Voto voto = new Voto();                
                
                //SETANDO O NUMERO DO CANDIDATO E PARTIDO
                voto.setNumero(num);
                voto.setId_cargo(4);
                
                //METODO PARA INSERIR O CANDIDATO
                voto_dao.Inserir_votos(voto);
                
                //MUNDANDO O LABELS PARA O PROXIMO CANDIDATO
                lbl_cargo.setText("PRESIDENTE");
                
                //ZERANDO OS LABELS E TEXTFIELD
                lbl_nome_candidato.setText("NENHUM");
                lbl_partido.setText("NENHUM");
                jt_1.setText(" ");
                jt_2.setText(" ");
            }
        }
        //SE O LABELS FOR IGUAL A PRESIDENTE
        else if(lbl_cargo.getText() == "PRESIDENTE")
        {
            //SE TODOS OS NUMERO PARA PRESINDETE NAO FORAM PREENCHIDOS
            if((" ".equals(jt_1.getText()) || " ".equals(jt_2.getText())))
            {
                JOptionPane.showMessageDialog(null, "Erro: Preencha todos os campos!");
            }
            else
            {
                //PEGANDO O NUMERO DIGITADO
                int num = Integer.parseInt(jt_1.getText()+jt_2.getText());
                
                //INSTANCIANDO A CLASSE VOTODAO E VOTO
                VotoDAO voto_dao = new VotoDAO();
                Voto voto = new Voto();
                
                
                //SETANDO O NUMERO DO CANDIDATO E PARTIDO
                voto.setNumero(num);
                voto.setId_cargo(5);
                
                //METODO PARA INSERIR O CANDIDATO
                voto_dao.Inserir_votos(voto);
                
                //ZERANDO OS LABELS E TEXTFIELD
                lbl_cargo.setText(" ");
                lbl_nome_candidato.setText(" ");
                lbl_partido.setText(" ");
                lbl_seu_voto.setText(" ");
                lbl_num.setText(" ");
                lbl_nome.setText(" ");
                lbl_par.setText(" ");
                lbl_fim.setText("FIM");
                jt_1.setVisible(false);
                jt_2.setVisible(false);
                btn_votar.setVisible(true);
                btn_voltar.setVisible(true);
            }
        }
        //JOptionPane.showMessageDialog(null, "foi!");
        
    }//GEN-LAST:event_btn_confirmaActionPerformed

    private void jt_5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jt_5KeyPressed
        
        
    }//GEN-LAST:event_jt_5KeyPressed

    private void jt_5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jt_5KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jt_5KeyTyped

    private void btn_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_2ActionPerformed
        
        //VERIFICANDO SE JA TEM NUMERO DIGITADO NO TEXTFIELD CASO NAO TENHA O TEXT FIELD RECEBE O NUMERO
        if(" ".equals(jt_1.getText()))
        {
            jt_1.setText("2");
        }
        else if(" ".equals(jt_2.getText()))
        {
            jt_2.setText("2");
        }
        else if(" ".equals(jt_3.getText()))
        {
            jt_3.setText("2");
        }
        else if(" ".equals(jt_4.getText()))
        {
            jt_4.setText("2");
        }
        else if(" ".equals(jt_5.getText()))
        {
            jt_5.setText("2");
        }
        Mostrar_candidato();
    }//GEN-LAST:event_btn_2ActionPerformed

    private void btn_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_3ActionPerformed
        
        //VERIFICANDO SE JA TEM NUMERO DIGITADO NO TEXTFIELD CASO NAO TENHA O TEXT FIELD RECEBE O NUMERO
        if(" ".equals(jt_1.getText()))
        {
            jt_1.setText("3");
        }
        else if(" ".equals(jt_2.getText()))
        {
            jt_2.setText("3");
        }
        else if(" ".equals(jt_3.getText()))
        {
            jt_3.setText("3");
        }
        else if(" ".equals(jt_4.getText()))
        {
            jt_4.setText("3");
        }
        else if(" ".equals(jt_5.getText()))
        {
            jt_5.setText("3");
        }
        Mostrar_candidato();
    }//GEN-LAST:event_btn_3ActionPerformed

    private void btn_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_4ActionPerformed
        
        //VERIFICANDO SE JA TEM NUMERO DIGITADO NO TEXTFIELD CASO NAO TENHA O TEXT FIELD RECEBE O NUMERO
        if(" ".equals(jt_1.getText()))
        {
            jt_1.setText("4");
        }
        else if(" ".equals(jt_2.getText()))
        {
            jt_2.setText("4");
        }
        else if(" ".equals(jt_3.getText()))
        {
            jt_3.setText("4");
        }
        else if(" ".equals(jt_4.getText()))
        {
            jt_4.setText("4");
        }
        else if(" ".equals(jt_5.getText()))
        {
            jt_5.setText("4");
        }
        Mostrar_candidato();
    }//GEN-LAST:event_btn_4ActionPerformed

    private void btn_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_5ActionPerformed
        
        //VERIFICANDO SE JA TEM NUMERO DIGITADO NO TEXTFIELD CASO NAO TENHA O TEXT FIELD RECEBE O NUMERO
        if(" ".equals(jt_1.getText()))
        {
            jt_1.setText("5");
        }
        else if(" ".equals(jt_2.getText()))
        {
            jt_2.setText("5");
        }
        else if(" ".equals(jt_3.getText()))
        {
            jt_3.setText("5");
        }
        else if(" ".equals(jt_4.getText()))
        {
            jt_4.setText("5");
        }
        else if(" ".equals(jt_5.getText()))
        {
            jt_5.setText("5");
        }
        Mostrar_candidato();
    }//GEN-LAST:event_btn_5ActionPerformed

    private void btn_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_6ActionPerformed
        
        //VERIFICANDO SE JA TEM NUMERO DIGITADO NO TEXTFIELD CASO NAO TENHA O TEXT FIELD RECEBE O NUMERO
        if(" ".equals(jt_1.getText()))
        {
            jt_1.setText("6");
        }
        else if(" ".equals(jt_2.getText()))
        {
            jt_2.setText("6");
        }
        else if(" ".equals(jt_3.getText()))
        {
            jt_3.setText("6");
        }
        else if(" ".equals(jt_4.getText()))
        {
            jt_4.setText("6");
        }
        else if(" ".equals(jt_5.getText()))
        {
            jt_5.setText("6");
        }
        Mostrar_candidato();
    }//GEN-LAST:event_btn_6ActionPerformed

    private void btn_7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_7ActionPerformed
        
        //VERIFICANDO SE JA TEM NUMERO DIGITADO NO TEXTFIELD CASO NAO TENHA O TEXT FIELD RECEBE O NUMERO
        if(" ".equals(jt_1.getText()))
        {
            jt_1.setText("7");
        }
        else if(" ".equals(jt_2.getText()))
        {
            jt_2.setText("7");
        }
        else if(" ".equals(jt_3.getText()))
        {
            jt_3.setText("7");
        }
        else if(" ".equals(jt_4.getText()))
        {
            jt_4.setText("7");
        }
        else if(" ".equals(jt_5.getText()))
        {
            jt_5.setText("7");
        }
        Mostrar_candidato();
    }//GEN-LAST:event_btn_7ActionPerformed

    private void btn_8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_8ActionPerformed
        
        //VERIFICANDO SE JA TEM NUMERO DIGITADO NO TEXTFIELD CASO NAO TENHA O TEXT FIELD RECEBE O NUMERO
        if(" ".equals(jt_1.getText()))
        {
            jt_1.setText("8");
        }
        else if(" ".equals(jt_2.getText()))
        {
            jt_2.setText("8");
        }
        else if(" ".equals(jt_3.getText()))
        {
            jt_3.setText("8");
        }
        else if(" ".equals(jt_4.getText()))
        {
            jt_4.setText("8");
        }
        else if(" ".equals(jt_5.getText()))
        {
            jt_5.setText("8");
        }
        Mostrar_candidato();
    }//GEN-LAST:event_btn_8ActionPerformed

    private void btn_9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_9ActionPerformed
        
        //VERIFICANDO SE JA TEM NUMERO DIGITADO NO TEXTFIELD CASO NAO TENHA O TEXT FIELD RECEBE O NUMERO
        if(" ".equals(jt_1.getText()))
        {
            jt_1.setText("9");
        }
        else if(" ".equals(jt_2.getText()))
        {
            jt_2.setText("9");
        }
        else if(" ".equals(jt_3.getText()))
        {
            jt_3.setText("9");
        }
        else if(" ".equals(jt_4.getText()))
        {
            jt_4.setText("9");
        }
        else if(" ".equals(jt_5.getText()))
        {
            jt_5.setText("9");
        }
        Mostrar_candidato();
    }//GEN-LAST:event_btn_9ActionPerformed

    private void btn_0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_0ActionPerformed
        
        //VERIFICANDO SE JA TEM NUMERO DIGITADO NO TEXTFIELD CASO NAO TENHA O TEXT FIELD RECEBE O NUMERO
        if(" ".equals(jt_1.getText()))
        {
            jt_1.setText("0");
        }
        else if(" ".equals(jt_2.getText()))
        {
            jt_2.setText("0");
        }
        else if(" ".equals(jt_3.getText()))
        {
            jt_3.setText("0");
        }
        else if(" ".equals(jt_4.getText()))
        {
            jt_4.setText("0");
        }
        else if(" ".equals(jt_5.getText()))
        {
            jt_5.setText("0");
        }
        Mostrar_candidato();
    }//GEN-LAST:event_btn_0ActionPerformed

    private void btn_brancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_brancoActionPerformed
        // TODO add your handling code here:
        jt_1.setText("0");
        jt_2.setText("0");
        jt_3.setText("0");
        jt_4.setText("0");
        jt_5.setText("0");
    }//GEN-LAST:event_btn_brancoActionPerformed

    private void btn_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_voltarActionPerformed
        
        //FECHAR A TELA DA URNA
        setVisible(false);

        //INSTANCIANDO FORM DE INICIO
        Inicio_view inicio = new Inicio_view();

        //DEIXANDO O INICIO VISIVEL
        inicio.setVisible(true);
    }//GEN-LAST:event_btn_voltarActionPerformed

    private void btn_votarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_votarActionPerformed
        
        String num = null;
        num = JOptionPane.showInputDialog("Digite seu numero de eleitor.");
        
        EleitorDAO eleitor_dao = new EleitorDAO();
        Eleitor eleitor = new Eleitor();
        
        eleitor.setNum_eleitor(Integer.parseInt(num));
        
        int result = eleitor_dao.Verifica_eleitor(eleitor);
        
        if(result > 0)
        {
            //DESABILITA O ELEITOR PARA NAO VOTAR DUAS VEZES
            eleitor_dao.Desabilita_eleitor(eleitor);
            //INICIA A VOTAÇÃO
            //INSTANCIANDO A CLASSE URNA_VIEW E DEIXANDO VISIVEL
            Urna_view u = new Urna_view();
            u.setVisible(true);

            //FECHANDO INICIO
            setVisible(false);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Erro: Eleitor não encontrado ou já voltou!");
        }
    }//GEN-LAST:event_btn_votarActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_0;
    private javax.swing.JButton btn_1;
    private javax.swing.JButton btn_2;
    private javax.swing.JButton btn_3;
    private javax.swing.JButton btn_4;
    private javax.swing.JButton btn_5;
    private javax.swing.JButton btn_6;
    private javax.swing.JButton btn_7;
    private javax.swing.JButton btn_8;
    private javax.swing.JButton btn_9;
    private javax.swing.JButton btn_branco;
    private javax.swing.JButton btn_confirma;
    private javax.swing.JButton btn_corrige;
    private javax.swing.JButton btn_voltar;
    private javax.swing.JButton btn_votar;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jt_1;
    private javax.swing.JTextField jt_2;
    private javax.swing.JTextField jt_3;
    private javax.swing.JTextField jt_4;
    private javax.swing.JTextField jt_5;
    private javax.swing.JLabel lbl_cargo;
    private javax.swing.JLabel lbl_fim;
    private javax.swing.JLabel lbl_nome;
    private javax.swing.JLabel lbl_nome_candidato;
    private javax.swing.JPanel lbl_nome_partido;
    private javax.swing.JLabel lbl_num;
    private javax.swing.JLabel lbl_par;
    private javax.swing.JLabel lbl_partido;
    private javax.swing.JLabel lbl_seu_voto;
    // End of variables declaration//GEN-END:variables
}
