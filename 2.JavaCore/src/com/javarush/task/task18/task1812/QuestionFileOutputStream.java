package com.javarush.task.task18.task1812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Расширяем AmigoOutputStream
*/

public class QuestionFileOutputStream implements AmigoOutputStream {
    AmigoOutputStream component;

    public QuestionFileOutputStream(AmigoOutputStream parameter) {
        this.component = parameter;
    }

    @Override
    public void flush() throws IOException {
        this.component.flush();
    }

    @Override
    public void write(int b) throws IOException {
        this.component.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        this.component.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        this.component.write(b, off, len);
    }

    @Override
    public void close() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
        String answer = br.readLine();
        if (answer.equals("Д")){
            this.component.close();
//            System.out.println("Поток закрыт");
        }else if((answer.equals("Н"))){
//            System.out.println("Отмена закрытия потока");
        }
//        else{
//            System.out.println("Введен некорректный ответ");
//        }
    }
}

