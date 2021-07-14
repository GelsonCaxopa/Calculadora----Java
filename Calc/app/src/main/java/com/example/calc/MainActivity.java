package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

//Usei a biblioteca exp4j para realizar as operacoes matematicas.

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button zero, one, two, three, four, five, six, seven, eight,
            nine, equals, minus, plus, rest, divided, times, dot, cleanScreen;   // declarando os botoes do layout

    private TextView operations, result;   // declarando os campos da tela do layout
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Components(); //Iniciando os botoes e tela.
        getSupportActionBar().hide(); //Usei para ocutar o appBar

        zero.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);     ///difinindo os eventos de clique dos botoes.
        nine.setOnClickListener(this);
        dot.setOnClickListener(this);
        equals.setOnClickListener(this);
        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        divided.setOnClickListener(this);
        times.setOnClickListener(this);
        rest.setOnClickListener(this);

        cleanScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operations.setText("");     //Criando a acao do botao C de limpar a tela, ele 'seta' vazio nos campos de operacoes e resultado
                result.setText("");
            }
        });


    equals.setOnClickListener(new View.OnClickListener() { // Criando a acao do botao = Igual.
        @Override
        public void onClick(View v) {

            try{
                Expression expression = new ExpressionBuilder(operations.getText().toString()).build();
                // a variavel resultd ira receber o resultado da operacao. O metodo Evaluate 'analisa' a operacao para gerar o resultado.

                double resultd = expression.evaluate();
                long resultl = (long) resultd;


                if(resultd == (double)resultl){

                    result.setText((CharSequence) String.valueOf(resultl));
                }else{
                    result.setText((CharSequence) String.valueOf(resultd));
                }
            }catch (Exception e){

            }



        }
    });

    }

    private void Components(){   //Recuperar os componentes do Layout.
        zero = findViewById(R.id.zero);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine =findViewById(R.id.nine);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        times = findViewById(R.id.times);
        divided = findViewById(R.id.divided);
        rest = findViewById(R.id.rest);
        equals = findViewById(R.id.equals);
        operations = findViewById(R.id.operations);
        result = findViewById(R.id.result);
        dot = findViewById(R.id.dot);
        cleanScreen = findViewById(R.id.cleanScreen);


    }
    public void OperationsAdd(String string, boolean cleanScreen){  //Classe para adicionar as operacoes na tela.
        if(result.getText().equals("")){
            operations.setText(" ");
        }
        if (cleanScreen) {
            result.setText(" ");
            operations.append(string);
        }else{
            operations.append(result.getText());
            operations.append(string);
            result.setText(" ");
        }
    }

    @Override
    public void onClick(View v) {
        /* Aqui usamos um switch para que quando clicar em um botao ele ira 'imprimir' na tela
         */
        switch (v.getId()){

            case R.id.zero:
                OperationsAdd("0", true);
                break;
            case R.id.one:
                OperationsAdd("1", true);
                break;
            case R.id.two:
                OperationsAdd("2", true);
                break;
            case R.id.three:
                OperationsAdd("3", true);
                break;
            case R.id.four:
                OperationsAdd("4", true);
                break;
            case R.id.five:
                OperationsAdd("5", true);
                break;
            case R.id.six:
                OperationsAdd("6", true);
                break;
            case R.id.seven:
                OperationsAdd("7", true);
                break;
            case R.id.eight:
                OperationsAdd("8", true);
                break;
            case R.id.nine:
                OperationsAdd("9", true);
                break;
            case R.id.dot:
                OperationsAdd(".", true);
                break;
            case R.id.plus:
                OperationsAdd("+", false);
                break;
            case R.id.minus:
                OperationsAdd("-", false);
                break;
            case R.id.times:
                OperationsAdd("*", false);
                break;
            case R.id.divided:
                OperationsAdd("/", false);
                break;

            case R.id.rest:
                OperationsAdd("%", false);
                break;

        }
    }
}