/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lpii.view;

import br.com.lpii.dao.ProfessorDAO;
import br.com.lpii.model.Professor;
import br.com.lpii.model.Utilitarios;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author
 */
public class FrmProfessores extends javax.swing.JFrame {

    /**
     * Método construtor
     */
    public FrmProfessores() {
        initComponents();
        Utilitarios u = new Utilitarios();
        u.inserirIcone(this);
        label_orientador.setEnabled(false);
        label_banca.setEnabled(false);
        txt_contaOrientador.setEnabled(false);
        txt_banca.setEnabled(false);
        txt_codigo.setEnabled(false);
        gerenciaCampos("block");
        gerenciaBotoes(true, false, false, false);

    }

    /**
     * Método para gerenciar campos bloquear - block | desbloquear unblock
     * limpar - clean
     */
    public void gerenciaCampos(String action) {
        switch (action) {
            case "block":
                txt_nome.setEnabled(false);
                txt_email.setEnabled(false);
                txt_senha.setEnabled(false);
                break;
            case "unblock":
                txt_nome.setEnabled(true);
                txt_email.setEnabled(true);
                txt_senha.setEnabled(true);
                break;
            case "clean":
                txt_codigo.setText("");
                txt_nome.setText("");
                txt_email.setText("");
                txt_senha.setText("");
                txt_pesquisar.setText("");
                break;
        }
    }

    /**
     * Métodos para gerenciar botões
     */
    public void gerenciaBotoes(boolean novo, boolean salvar, boolean editar, boolean excluir) {
        btn_novo.setEnabled(novo);
        btn_salvar.setEnabled(salvar);
        btn_editar.setEnabled(editar);
        btn_excluir.setEnabled(excluir);
    }

    /**
     * Método para garantir que não vá número no campo matrícula
     */
    public void ValidaNumero(JTextField matrícula) {
        long valor;
        if (matrícula.getText().length() != 0) {
            try {
                valor = Long.parseLong(matrícula.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Campo matrícula só aceita números", "Informação", JOptionPane.INFORMATION_MESSAGE);
                matrícula.grabFocus();
                txt_codigo.setText("");
            }
        }
    }

    /**
     * Método responsável por carregar dados para tabela professors
     */
    public void toList() {
        // Instancia objeto DAO
        ProfessorDAO dao = new ProfessorDAO();
        // Armazena em uma lista o retorno do método listarAlunos
        List<Professor> lista = dao.listarProfessor();
        // Cria o DefaultTableModel para armazenar os dados que serão exibidos na tabela
        DefaultTableModel dados = (DefaultTableModel) tbl_professor.getModel();
        // limpa dados da tabela
        dados.setNumRows(0);

        // cada ocorrência em lista irá para um objeto professor
        for (Professor p : lista) {
            // E agora será adicionado a lista na tabela. Linha a linha
            dados.addRow(new Object[]{
                p.getCodigo(),
                p.getNome(),
                p.getEmail(),});
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        txt_pesquisar = new javax.swing.JTextField();
        btn_consulta_pesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_professor = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_codigo = new javax.swing.JTextField();
        txt_nome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        label_orientador = new javax.swing.JLabel();
        txt_banca = new javax.swing.JTextField();
        label_banca = new javax.swing.JLabel();
        txt_contaOrientador = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_senha = new javax.swing.JPasswordField();
        btn_novo = new javax.swing.JButton();
        btn_salvar = new javax.swing.JButton();
        btn_editar = new javax.swing.JButton();
        btn_excluir = new javax.swing.JButton();

        jLabel7.setText("jLabel7");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Professores");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 153, 51));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(0, 153, 51));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cadastro de Professores");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/logo-instituto.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setForeground(new java.awt.Color(0, 102, 51));
        jTabbedPane1.setFocusable(false);
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        txt_pesquisar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_pesquisar.setForeground(new java.awt.Color(153, 153, 153));
        txt_pesquisar.setText("Digite o nome do professor");
        txt_pesquisar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_pesquisarFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_pesquisarFocusLost(evt);
            }
        });

        btn_consulta_pesquisar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_consulta_pesquisar.setForeground(new java.awt.Color(0, 102, 51));
        btn_consulta_pesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/zoom.png"))); // NOI18N
        btn_consulta_pesquisar.setText("Pesquisar");
        btn_consulta_pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_consulta_pesquisarActionPerformed(evt);
            }
        });

        tbl_professor.setForeground(new java.awt.Color(0, 153, 51));
        tbl_professor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_professor.setGridColor(new java.awt.Color(153, 153, 153));
        tbl_professor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_professorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_professor);
        if (tbl_professor.getColumnModel().getColumnCount() > 0) {
            tbl_professor.getColumnModel().getColumn(0).setPreferredWidth(30);
            tbl_professor.getColumnModel().getColumn(1).setPreferredWidth(140);
            tbl_professor.getColumnModel().getColumn(2).setPreferredWidth(140);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txt_pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_consulta_pesquisar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 825, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_consulta_pesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(273, 273, 273))
        );

        jTabbedPane1.addTab("Consulta de Professores", jPanel4);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 51));
        jLabel2.setText("Código");

        txt_codigo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_codigo.setForeground(new java.awt.Color(0, 102, 51));
        txt_codigo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoFocusLost(evt);
            }
        });

        txt_nome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_nome.setForeground(new java.awt.Color(0, 102, 51));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 51));
        jLabel3.setText("Nome:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 51));
        jLabel4.setText("Email:");

        txt_email.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_email.setForeground(new java.awt.Color(0, 102, 51));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Número de projetos relacionados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(153, 153, 153))); // NOI18N

        label_orientador.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label_orientador.setForeground(new java.awt.Color(0, 102, 51));
        label_orientador.setText("Orientador");

        label_banca.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label_banca.setForeground(new java.awt.Color(0, 102, 51));
        label_banca.setText("Banca:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(label_orientador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_contaOrientador, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addComponent(label_banca)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_banca, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_orientador)
                    .addComponent(txt_banca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_banca)
                    .addComponent(txt_contaOrientador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 51));
        jLabel6.setText("Senha");

        txt_senha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_senha.setForeground(new java.awt.Color(0, 102, 51));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_senha, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(165, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Dados do professor", jPanel2);

        btn_novo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_novo.setForeground(new java.awt.Color(0, 102, 51));
        btn_novo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add.png"))); // NOI18N
        btn_novo.setText("Novo");
        btn_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_novoActionPerformed(evt);
            }
        });

        btn_salvar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_salvar.setForeground(new java.awt.Color(0, 102, 51));
        btn_salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/disk.png"))); // NOI18N
        btn_salvar.setText("Salvar");
        btn_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salvarActionPerformed(evt);
            }
        });

        btn_editar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_editar.setForeground(new java.awt.Color(0, 102, 51));
        btn_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pencil.png"))); // NOI18N
        btn_editar.setText("Editar");
        btn_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editarActionPerformed(evt);
            }
        });

        btn_excluir.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_excluir.setForeground(new java.awt.Color(0, 102, 51));
        btn_excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancel.png"))); // NOI18N
        btn_excluir.setText("Excluir");
        btn_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_excluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 886, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(175, 175, 175)
                .addComponent(btn_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_salvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_editar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_excluir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_editar, btn_excluir, btn_novo, btn_salvar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btn_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_salvar)
                    .addComponent(btn_editar)
                    .addComponent(btn_excluir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btn_editar, btn_excluir, btn_novo, btn_salvar});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salvarActionPerformed

        /**
         * Instancia objeto da classe AlunoDao Já é aberta a conexão a partir do
         * construtor
         */
        ProfessorDAO dao = new ProfessorDAO();

        if (!txt_codigo.getText().equals("") && dao.verificaProfessor(Integer.parseInt(txt_codigo.getText()))) {

            /**
             * Instancia objeto da classe AlunoDao Já é aberta a conexão a
             * partir do construtor
             */
            ProfessorDAO daoP = new ProfessorDAO();
            /**
             * Ação responsável por Editar Aluno insere dados no objeto
             * professor
             */
            Professor professor = new Professor();

            professor.setCodigo(Integer.parseInt(txt_codigo.getText()));
            professor.setNome(txt_nome.getText());
            professor.setEmail(txt_email.getText());
            professor.setSenha(String.valueOf(txt_senha.getPassword()));

            /**
             * Método que irá salbar o obj Aluno no banco de dados
             */
            daoP.alterarProfessor(professor);

            /**
             * Atualiza table professor após a edição
             */
            toList();
        } else {

            // Ação responsável por salvar no banco de dados
            /**
             * insere dados no objeto professor
             */
            Professor professor = new Professor();
            professor.setNome(txt_nome.getText());
            professor.setEmail(txt_email.getText());
            professor.setSenha(String.valueOf(txt_senha.getPassword()));
            professor.setConta_banca(0);

            /**
             * Método que irá salbar o obj Aluno no banco de dados
             */
            dao.cadastrarProfessor(professor);

        }

        /**
         * Limpa os campos do formulário
         */
        gerenciaCampos("clean");
        // bloqueia campos
        gerenciaCampos("block");
        // libera botão para cadastro de um novo professor
        gerenciaBotoes(true, false, false, false);

    }//GEN-LAST:event_btn_salvarActionPerformed

    private void btn_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_novoActionPerformed
        // Muda para a aba do formulário
        jTabbedPane1.setSelectedIndex(1);
        // Libera os campos para preenchimento dos dados do professor
        gerenciaCampos("unblock");
        gerenciaCampos("clean");
        // libera o botão salvar e obloqueia os demais
        gerenciaBotoes(true, true, false, false);
        // Foco no campo matrícula
        txt_codigo.requestFocus();
    }//GEN-LAST:event_btn_novoActionPerformed

    private void tbl_professorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_professorMouseClicked

        FrmLoading loading = new FrmLoading();
        loading.setLabel("Carregando dados do Professor...");
        loading.setVisible(true);

        Thread t = new Thread() {
            public void run() {

                // Libera botões editar e exluir
                gerenciaBotoes(true, false, true, true);

                // Verifica se foi disparado duplo click sobre uma linha da tabela
                if (evt.getClickCount() == 2) {
                    // Comando para carregar para outra aba
                    jTabbedPane1.setSelectedIndex(1);
                }

                try {
                    // Pega o ID vindo da tabela
                    int codProfessor = Integer.parseInt(tbl_professor.getValueAt(tbl_professor.getSelectedRow(), 0).toString());
                    // Busca os dados na tabela
                    ProfessorDAO dao = new ProfessorDAO();
                    Professor professor = dao.buscaProfessor(codProfessor);

                    // Pega os dados e envia para o formulário de clientes
                    txt_codigo.setText(String.valueOf(professor.getCodigo()));
                    txt_nome.setText(professor.getNome());
                    txt_email.setText(professor.getEmail());
                    txt_senha.setText(professor.getSenha());
                    txt_contaOrientador.setText(String.valueOf(professor.getConta_orientador()));
                    txt_banca.setText(String.valueOf(professor.getConta_banca()));
                    txt_contaOrientador.setText(String.valueOf(professor.getConta_orientador()));

                    jTabbedPane1.setSelectedIndex(1);
                } catch (ArrayIndexOutOfBoundsException erro) {
                    JOptionPane.showMessageDialog(null, "Erro ao selecionar professor. Tente novamente.");
                }

                loading.dispose();
            }

        };

        t.start();


    }//GEN-LAST:event_tbl_professorMouseClicked

    private void btn_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarActionPerformed

        // Verifica se botão está sendo pressionado na aba dados ou busca
        if (jTabbedPane1.getSelectedIndex() == 1) {
            // se na aba busca apenas direciona para a aba dados
            jTabbedPane1.setSelectedIndex(1);
            gerenciaCampos("unblock");
            gerenciaBotoes(true, true, false, true);
        } else if (jTabbedPane1.getSelectedIndex() == 0 && !txt_nome.isEnabled()) {

            // Libera campos e botões
            gerenciaCampos("unblock");
            gerenciaBotoes(true, true, false, true);
        }

    }//GEN-LAST:event_btn_editarActionPerformed

    private void btn_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_excluirActionPerformed

        /**
         * Ação responsável por excluir Aluno insere dados no objeto professor
         */
        Professor professor = new Professor();
        professor.setCodigo(Integer.parseInt(txt_codigo.getText()));

        /**
         * Instancia objeto da classe AlunoDao Já é aberta a conexão a partir do
         * construtor
         */
        ProfessorDAO dao = new ProfessorDAO();

        /**
         * Método que irá salbar o obj Aluno no banco de dados
         */
        dao.excluirProfessor(professor);

        /**
         * Atualiza table professor após a edição
         */
        toList();
        gerenciaCampos("clean");
        // Comando para carregar para outra aba
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_btn_excluirActionPerformed

    private void txt_codigoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoFocusLost
        ValidaNumero(txt_codigo);
    }//GEN-LAST:event_txt_codigoFocusLost

    private void btn_consulta_pesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_consulta_pesquisarActionPerformed
        // Crio o parâmetro que será utilizado na busca
        String param = "%" + txt_pesquisar.getText() + "%";

        // Instancia objeto DAO
        ProfessorDAO dao = new ProfessorDAO();
        // Armazena em uma lista o retorno do método listarAlunos
        List<Professor> lista = dao.buscaProfessor(param);
        // Cria o DefaultTableModel para armazenar os dados que serão exibidos na tabela
        DefaultTableModel dados = (DefaultTableModel) tbl_professor.getModel();
        // limpa dados da tabela
        dados.setNumRows(0);

        // cada ocorrência em lista irá para um objeto professor
        for (Professor p : lista) {
            // E agora será adicionado a lista na tabela. Linha a linha
            dados.addRow(new Object[]{
                p.getCodigo(),
                p.getNome(),
                p.getEmail()
            });
        }
    }//GEN-LAST:event_btn_consulta_pesquisarActionPerformed

    private void txt_pesquisarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_pesquisarFocusGained
        if (!txt_pesquisar.getText().equals("") && txt_pesquisar.getText().equals("Digite o nome do professor")) {
            txt_pesquisar.setText("");
        }
    }//GEN-LAST:event_txt_pesquisarFocusGained

    private void txt_pesquisarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_pesquisarFocusLost
        if (txt_pesquisar.getText().equals("")) {
            txt_pesquisar.setText("Digite o nome do professor");
            toList();
        }
    }//GEN-LAST:event_txt_pesquisarFocusLost

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        FrmLoading loading = new FrmLoading();
        loading.setLabel("Carregando professores...");
        loading.setVisible(true);

        Thread t = new Thread() {
            public void run() {
                /**
                 * Evento responsável por carregar os dados para a tabela de
                 * professor. O método é disparado no momento em que o
                 * formulário é aberto
                 */
                toList();
                loading.dispose();
            }

        };

        t.start();


    }//GEN-LAST:event_formWindowOpened

    /**
     * Método main do FrmProfessores
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmProfessores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmProfessores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmProfessores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmProfessores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmProfessores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_consulta_pesquisar;
    private javax.swing.JButton btn_editar;
    private javax.swing.JButton btn_excluir;
    private javax.swing.JButton btn_novo;
    private javax.swing.JButton btn_salvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel label_banca;
    private javax.swing.JLabel label_orientador;
    private javax.swing.JTable tbl_professor;
    private javax.swing.JTextField txt_banca;
    private javax.swing.JTextField txt_codigo;
    private javax.swing.JTextField txt_contaOrientador;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_nome;
    private javax.swing.JTextField txt_pesquisar;
    private javax.swing.JPasswordField txt_senha;
    // End of variables declaration//GEN-END:variables
}
