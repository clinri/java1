package ru.progwards.java1.lessons.io2;

import java.io.RandomAccessFile;

//Создать статический метод
// public static void censorFile(String inoutFileName, String[] obscene),
// в котором прочитать файл inoutFileName и заменить слова, содержащиеся в String[] obscene на '*',
// соответствующие количеству символов в слове, изменения записать в исходный файл.
// В случае возникновения ошибки, выбросить свое собственное исключение CensorException
// в котором сохранить - строку, полученную у оригинального exception через метод getMessage() и имя файла,
// в котором возникла ошибка. В классе перекрыть метод toString(), вернув <имя файла>:<строка ошибки>.
// Класс CensorException разместить в классе Censor
//
//Например файл содержит:
//Java — строго типизированный объектно-ориентированный язык программирования,
// разработанный компанией Sun Microsystems (в последующем приобретённой компанией Oracle).
//obscene = {"Java", "Oracle", "Sun", "Microsystems"}
//
//Должен выдать результат:
//**** — строго типизированный объектно-ориентированный язык программирования,
// разработанный компанией *** ************ (в последующем приобретённой компанией ******).
public class Censor {
    public static class CensorException extends Exception {
        public String fileName = "";
        public String exMessage;
        public int numberEx;

        public CensorException(String fileName, String exMessage, String numberEx) {
            this.fileName = fileName;
            this.numberEx = numberEx;
            this.exMessage = exMessage;
        }

        @Override
        public String getMessage() {
            return this.exMessage + " " + fileName;
        }

        @Override
        public String toString() {
            return this.fileName + ":" + this.numberEx;
        }
    }

    public static void censorFile(String inoutFileName, String[] obscene) throws CensorException {
        try (RandomAccessFile file = new RandomAccessFile(inoutFileName, "rw")) {
            String textIn ="";
            textIn = new String(file.readLine().getBytes("ISO-8859-1"),"UTF-8");
            String [] obsceneStars = new String[obscene.length];
            System.out.println(textIn);
            for (int i=0;i<obscene.length;i++){
                obsceneStars[i] = obscene[i].replaceAll("\\D","*");
                System.out.println(obscene[i] +" "+ obsceneStars[i]);
                textIn = textIn.replaceAll(obscene[i],obsceneStars[i]);
            }
            System.out.println(textIn);
            file.seek(0);
            file.write(textIn.getBytes("UTF8"));
        } catch (Exception ex){
            throw new CensorException(inoutFileName,ex.getMessage(),inoutFileName == null ? "null" : String.valueOf(ex.getStackTrace()[0].getLineNumber()));
        }
    }


    public static void main(String[] args) {
        String[] obsense = {"Java", "Oracle", "Sun", "Microsystems"};
        try {
            censorFile("file.txt", obsense);
        } catch (CensorException e){
            System.out.println(e);
            System.out.println(e.getMessage());
        }
    }
}
