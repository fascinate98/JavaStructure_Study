package com.javaex.gradeprogram_map;

//import java.security.KeyStore.Entry;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
//import java.util.Set;
//import javax.sql.rowset.serial.SerialArray;

public class Init {

    Map<Integer, Student> data = new HashMap<>();
    Scanner scanner = new Scanner(System.in);

    public void Start(){

        boolean b = true;
        while(b)
        {
            
            System.out.println("성적처리프로그램");
            System.err.println("1. 입력  // 2. 검색  //3. 출력 //4. 삭제 //5. 종료");
            int c = scanner.nextInt();

            switch(c){
                case 1:
                    Scan();
                    break;
                case 2:
                    NameSearch();
                    break;

                case 3: 
                    Print();
                    break;
                case 4: 
                    DeleteData();
                    break;
                case 5:
                    b = false;
                    break;
                

            }
           
        }
        scanner.close();
    }

    public void DeleteData(){
        String name;
        System.out.println("삭제할 사람이름 : ");
        name = scanner.next();

        Student d = Search(name);
        int key = (int)GetKey(d);
        data.remove(key);

        System.out.println("삭제 완료");
    }

    public Object GetKey(Object value) {

        for(Object o: data.keySet()) {
    
            if(data.get(o).equals(value)) {
                return o;
            }
        }
        return null;
    }

    public void AveSearch(){
        for(int i = 0; i <= data.size() - 1; i++){
            if(data.get(i).getAverage() >= 50)
            {
                Print(data.get(i));
                //System.out.println(data[i].toString());
            }

        }

    }


    public Student Search(String name){
        for(int i = 0; i <= data.size() - 1; i++){
            data.keySet();
            if(data.get(i).getName().equals(name) )
            {
                return data.get(i);
            }

        }
        System.out.println("그런 사람은 존재하지 않아..");;
        return null;

    }

    public void NameSearch(){
        String name = null;
        Student s = null;
        System.out.println("1. 이름검색 // 2. 평균검색");
        int c = scanner.nextInt();
        switch(c){
            case 1:
                name = scanner.next();
                s = Search(name);
                Print(s);
                break;
            case 2:
                AveSearch();
                break;
        
        }

    }


    public void Average(){
        for(int i = 0; i <= data.size() - 1; i++){
            int sum = 0; 

            sum = data.get(i).getKor_grade() + data.get(i).getEng_grade() + data.get(i).getMat_grade();

            data.get(i).setAverage((float)sum / 3);
        }
    }

    public void Scan(){

        int count, kor, eng, mat;
        String name = ""; 

        System.out.println("인원 수 : ");
        count = scanner.nextInt();


        for(int i = 0; i <= count - 1; i++)
        {
            Student s = new Student();
            System.out.println(i + 1 + "번째 학생 이름 입력 : ");
            name = scanner.next();
            System.out.println("국어 점수 : " );
            kor = scanner.nextInt();
            System.out.println("영어 점수 : "  );
            eng = scanner.nextInt();
            System.out.println("수학 점수 : " );
            mat = scanner.nextInt();

            s.setName(name);
            s.setKor_grade(kor);
            s.setEng_grade(eng);
            s.setMat_grade(mat);

            data.put(Integer.valueOf(i), s);

            
        }
        Average();

    }

    public void Print(){
        for(int key : data.keySet()) 
        { 
            Student value = (Student) data.get(key); 
            System.out.println(key + " : " + value); 
        }

    }

    public void Print(Student s){
        System.out.println(s.toString());
    }
}
