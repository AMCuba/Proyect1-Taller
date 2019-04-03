/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.yourorghere;

/**
 *
 * @author ACER
 */
import com.sun.opengl.util.Animator;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
import javax.swing.JFrame;



public class Graficas extends JFrame {
    public int cordX;
    public int cordY;
    public int tamLin;
    public int selector;
    static GL gl;
    static GLU glu;

    public Graficas(String titulo , int height, int weight){
        setTitle(titulo);
        setSize(height,weight);
        //Instanciamos la clase Graphic
        GraphicListener listener = new GraphicListener();
        //Creamos el canvas
        GLCanvas canvas = new GLCanvas(new GLCapabilities());
        canvas.addGLEventListener(listener);
        getContentPane().add(canvas);
    }

   public static void main (String args[]){ // este metodo lo vamos a quitar, pues esto ira a otra clase q va a ser la prueba
        Graficas frame = new Graficas("paquete", 500 , 500);
        frame.selecionarForma(1); // 1 cuadr , 2 triang, 3 circulo(si se puede) , 4 poligono , 5... veremos q mas ponerle
        frame.fijarTamLin(0);     // el 
        frame.ubicarPosicion(0,0);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
   public void selecionarForma(int sel){
       this.selector = sel;
   }
   public void ubicarPosicion (int x , int y){
       this.cordX = x;
       this.cordY = y;
   }
   public void fijarTamLin (int tam){
       this.tamLin = tam;
   }
   public void dibujar (int selector , int x , int y, int tam){
       switch(selector){
           case 1: dibujarCuadrado(x,y,tam);
           //case 2 : dibujarTriangulo()
       }
   }
   public void dibujarCuadrado(int x, int y, int tam){
       gl.glBegin(GL.GL_QUADS); //con esto inicias a dibujar lo q ponas ennesa cosa entre prentesis
       gl.glColor3f(1,0,0);
            gl.glVertex2f(10+x, 10+y);
            gl.glVertex2f(20+x, 10+y);
            gl.glVertex2f(10+x, 30+y);
            gl.glVertex2f(20+x, 30+y);
        gl.glEnd();//con esto terminas de dibujar
       
   }
    public class GraphicListener implements GLEventListener{

        public void display(GLAutoDrawable arg0) {

            glu = new GLU();
            gl = arg0.getGL();

            gl.glClearColor(0, 0, 1, 0);

            //Establecer los parametros para la proyeccion
            gl.glMatrixMode(gl.GL_PROJECTION);
            glu.gluOrtho2D(0, 200, 0, 150);
            dibujar(selector,cordX,cordY,tamLin);
           //Indicamos que vamos a iniciar a crear lineas
          
            
                  gl.glFlush();// esto pos, borra la pantalla  y la dibuja de nuevo a cada rato

        }

        public void init(GLAutoDrawable arg0) {
 //           gl = arg0.getGL();
 //           gl.glEnable(gl.GL_BLEND);
 //           gl.glBlendFunc(gl.GL_SRC_ALPHA, gl.GL_ONE_MINUS_SRC_ALPHA);
        }

        public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {

        }

        public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {

        }

    }


}
