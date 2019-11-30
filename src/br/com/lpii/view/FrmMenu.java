/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lpii.view;

import br.com.lpii.model.Utilitarios;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Alexandre Lima
 */
public class FrmMenu extends javax.swing.JFrame {

    private String tipoUsuario;
    private String nomeUsuario;
    private String idUsuario;

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }
    

    /**
     * Creates new form FrmMenu
     */
    public FrmMenu() {
        initComponents();
        Utilitarios util = new Utilitarios();
        util.inserirIcone(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImageIcon icon = new ImageIcon(getClass().getResource("/imagens/wallspaper.jpg"));
        Image image = icon.getImage();
        painel_desk = new javax.swing.JDesktopPane(){

            public void paintComponent(Graphics g) {
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        jPanel1 = new javax.swing.JPanel();
        label_usuario = new javax.swing.JLabel();
        txt_usuario = new javax.swing.JLabel();
        label_matrícula = new javax.swing.JLabel();
        txt_matrícula = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu_arquivo = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        menu_aluno = new javax.swing.JMenu();
        submenu_aluno = new javax.swing.JMenuItem();
        Aluno_meuCadastro = new javax.swing.JMenuItem();
        menu_professor = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        menu_propostas = new javax.swing.JMenu();
        menu_prof_gerenciarPropostas = new javax.swing.JMenuItem();
        menu_aluno_escolherTema = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Gerenciamento dos TC do Curso de SSI");
        setBackground(new java.awt.Color(255, 255, 255));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        label_usuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label_usuario.setForeground(new java.awt.Color(0, 102, 51));
        label_usuario.setText("Usuário: ");

        txt_usuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_usuario.setForeground(new java.awt.Color(0, 102, 0));
        txt_usuario.setText("Alexandre Lima");

        label_matrícula.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label_matrícula.setForeground(new java.awt.Color(0, 102, 51));
        label_matrícula.setText("Matrícula:");

        txt_matrícula.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_matrícula.setForeground(new java.awt.Color(0, 102, 0));
        txt_matrícula.setText("Alexandre Lima");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_matrícula)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_matrícula)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_usuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_usuario)
                .addContainerGap(577, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(label_matrícula)
                .addComponent(txt_matrícula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label_usuario)
                .addComponent(txt_usuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        painel_desk.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout painel_deskLayout = new javax.swing.GroupLayout(painel_desk);
        painel_desk.setLayout(painel_deskLayout);
        painel_deskLayout.setHorizontalGroup(
            painel_deskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        painel_deskLayout.setVerticalGroup(
            painel_deskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_deskLayout.createSequentialGroup()
                .addGap(0, 479, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        menu_arquivo.setForeground(new java.awt.Color(0, 102, 51));
        menu_arquivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/page.png"))); // NOI18N
        menu_arquivo.setText("Arquivo");
        menu_arquivo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/arrow_refresh.png"))); // NOI18N
        jMenuItem5.setText("Trocar de usuário");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        menu_arquivo.add(jMenuItem5);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem1.setForeground(new java.awt.Color(0, 102, 51));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/door_out.png"))); // NOI18N
        jMenuItem1.setText("Sair");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menu_arquivo.add(jMenuItem1);

        jMenuBar1.add(menu_arquivo);

        menu_aluno.setForeground(new java.awt.Color(0, 102, 51));
        menu_aluno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/user.png"))); // NOI18N
        menu_aluno.setText("Aluno");
        menu_aluno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        submenu_aluno.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        submenu_aluno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        submenu_aluno.setForeground(new java.awt.Color(0, 102, 51));
        submenu_aluno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/user_edit.png"))); // NOI18N
        submenu_aluno.setText("Gerenciar Alunos");
        submenu_aluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenu_alunoActionPerformed(evt);
            }
        });
        menu_aluno.add(submenu_aluno);

        Aluno_meuCadastro.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        Aluno_meuCadastro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Aluno_meuCadastro.setForeground(new java.awt.Color(0, 102, 51));
        Aluno_meuCadastro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/user_edit.png"))); // NOI18N
        Aluno_meuCadastro.setText("Meu Cadastro");
        Aluno_meuCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Aluno_meuCadastroActionPerformed(evt);
            }
        });
        menu_aluno.add(Aluno_meuCadastro);

        jMenuBar1.add(menu_aluno);

        menu_professor.setForeground(new java.awt.Color(0, 102, 51));
        menu_professor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/group.png"))); // NOI18N
        menu_professor.setText("Professor");
        menu_professor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem3.setForeground(new java.awt.Color(0, 102, 51));
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/group_edit.png"))); // NOI18N
        jMenuItem3.setText("Gerenciar Professores");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        menu_professor.add(jMenuItem3);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem6.setForeground(new java.awt.Color(0, 102, 51));
        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/text_list_bullets.png"))); // NOI18N
        jMenuItem6.setText("Selecionar Áreas de Interesse");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        menu_professor.add(jMenuItem6);

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem7.setForeground(new java.awt.Color(0, 102, 51));
        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add.png"))); // NOI18N
        jMenuItem7.setText("Cadastrar Minhas Propostas");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        menu_professor.add(jMenuItem7);

        jMenuBar1.add(menu_professor);

        menu_propostas.setForeground(new java.awt.Color(0, 102, 51));
        menu_propostas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/book.png"))); // NOI18N
        menu_propostas.setText("Propostas TCC");
        menu_propostas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        menu_prof_gerenciarPropostas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        menu_prof_gerenciarPropostas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        menu_prof_gerenciarPropostas.setForeground(new java.awt.Color(0, 102, 51));
        menu_prof_gerenciarPropostas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/book_open.png"))); // NOI18N
        menu_prof_gerenciarPropostas.setText("Gerenciar Propostas");
        menu_prof_gerenciarPropostas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_prof_gerenciarPropostasActionPerformed(evt);
            }
        });
        menu_propostas.add(menu_prof_gerenciarPropostas);

        menu_aluno_escolherTema.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        menu_aluno_escolherTema.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        menu_aluno_escolherTema.setForeground(new java.awt.Color(0, 102, 51));
        menu_aluno_escolherTema.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/book_open.png"))); // NOI18N
        menu_aluno_escolherTema.setText("Escolher Tema");
        menu_aluno_escolherTema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_aluno_escolherTemaActionPerformed(evt);
            }
        });
        menu_propostas.add(menu_aluno_escolherTema);

        jMenuBar1.add(menu_propostas);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel_desk)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel_desk)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        this.setExtendedState(this.MAXIMIZED_BOTH);

        if (tipoUsuario.equals("Aluno")) {
            txt_usuario.setText(nomeUsuario);
            label_usuario.setText("Aluno(a):");
            txt_matrícula.setText(idUsuario);
            label_matrícula.setText("Matrícula:");
        } else if (tipoUsuario.equals("Professor")) {
            txt_usuario.setText(nomeUsuario);
            label_usuario.setText("Professor(a):");
            txt_matrícula.setText(idUsuario);
            label_matrícula.setText("ID:");
        }

        this.setVisible(true);
    }//GEN-LAST:event_formWindowActivated

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed

        FrmLogin telaLogin = new FrmLogin();
        this.dispose();
        telaLogin.setVisible(true);

    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

        int op;

        op = JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja sai?");

        if (op == 0) {
            System.exit(0);
        }

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void submenu_alunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenu_alunoActionPerformed
        FrmAluno tela = new FrmAluno();
        tela.setVisible(true);
    }//GEN-LAST:event_submenu_alunoActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        FrmProfessores tela = new FrmProfessores();
        tela.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        FrmAreaInteresse tela = new FrmAreaInteresse();
        tela.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        FrmMinhasPropostas tela = new FrmMinhasPropostas();
        tela.setVisible(true);

    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void menu_prof_gerenciarPropostasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_prof_gerenciarPropostasActionPerformed
        // Abre formulário para gerenciamento de propostas para o TC
        FrmGerenciarPropostas tela = new FrmGerenciarPropostas();
        tela.setVisible(true);
    }//GEN-LAST:event_menu_prof_gerenciarPropostasActionPerformed

    private void Aluno_meuCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Aluno_meuCadastroActionPerformed
        
        FrmMeuCadastro tela = new FrmMeuCadastro();
        tela.setIdUsuario(idUsuario);
        tela.setVisible(true);
        
    }//GEN-LAST:event_Aluno_meuCadastroActionPerformed

    private void menu_aluno_escolherTemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_aluno_escolherTemaActionPerformed
        // Abre JFrame para aluno escolher tema
        FrmEscolherTema tela = new FrmEscolherTema();
        tela.setVisible(true);
    }//GEN-LAST:event_menu_aluno_escolherTemaActionPerformed

    /**
     * @param args the command line arguments
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
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JMenuItem Aluno_meuCadastro;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel label_matrícula;
    private javax.swing.JLabel label_usuario;
    private javax.swing.JMenu menu_aluno;
    public javax.swing.JMenuItem menu_aluno_escolherTema;
    private javax.swing.JMenu menu_arquivo;
    public javax.swing.JMenuItem menu_prof_gerenciarPropostas;
    public javax.swing.JMenu menu_professor;
    private javax.swing.JMenu menu_propostas;
    private javax.swing.JDesktopPane painel_desk;
    public javax.swing.JMenuItem submenu_aluno;
    private javax.swing.JLabel txt_matrícula;
    private javax.swing.JLabel txt_usuario;
    // End of variables declaration//GEN-END:variables
}
