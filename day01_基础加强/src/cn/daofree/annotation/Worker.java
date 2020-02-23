package cn.daofree.annotation;



@MyAnno(value=12,per = Person.P1,anno2 = @MyAnno2,strs={"bbb","ccc"},show2="1")
@MyAnno3
public class Worker {
    @MyAnno3
    public String name = "aaa";
    @MyAnno3
    public void show(){


    }
}
