import java.util.ArrayList;

public class PassGenerator {
    private int lengthPass;
    private char[] specSymbol = {'.', ',', ':', ';', '?', '!',
            '*', '+', '%', '-', '<', '>', '@', '[', ']', '{',
            '}', '/', '_', '{','}', '$', '#'};

    private boolean haveSmallLatin;
    private boolean haveBigLatin;
    private boolean haveNumber;
    private boolean haveSpecSymbol;

    private boolean specSimvol;
    private boolean bigLathin;
    private boolean lathin;
    private boolean numbers;

    public PassGenerator(int lengthPass,
                         boolean specSimvol,
                         boolean bigLathin,
                         boolean lathin,
                         boolean numbers) {
        this.specSimvol = specSimvol;
        this.bigLathin = bigLathin;
        this.lathin = lathin;
        this.numbers = numbers;
        this.lengthPass = lengthPass;
    }

    public PassGenerator(int lengthPass) {
        this.lengthPass = lengthPass;
    }
    private char generateSpecSymbol(){
        char ch = specSymbol[(int)(Math.random()*specSymbol.length)];
        haveSpecSymbol = true;
        return ch;
    }
    private char generateSmallLatin(){
        char ch=(char)(97+(int)(Math.random()*26));
        haveSmallLatin = true;
        return ch;
    }
    private char generateBigLatin(){
        char ch=(char)(65 + (int)(Math.random()*26));
        haveBigLatin = true;
        return ch;
    }
    private char generateNumber(){
        char ch=(char)(49 + (int)(Math.random()*9));
        haveNumber = true;
        return ch;
    }
    public String generate(){
        String currentPass = "";

        setHaveFalse();

        while(currentPass.length()<lengthPass){
            char currentSymbol = 0;
            if (requiredHave()<(lengthPass-currentPass.length())){
                currentSymbol = pGenerate();
            } else{
                currentSymbol = requiredGenerate();
            }
            if (currentSymbol!=0)
            currentPass = currentPass+currentSymbol;

        }
        return currentPass;
    }
    private int requiredHave(){
        int count = 0;

        if(!haveNumber) count++;
        if(!haveBigLatin) count++;
        if(!haveSmallLatin) count++;
        if(!haveSpecSymbol) count++;

        return count;
    }
    private void setHaveFalse() {
        haveSpecSymbol = !specSimvol;
        haveSmallLatin = !lathin;
        haveBigLatin = !bigLathin;
        haveNumber = !numbers;
    }

    private char pGenerate(){
        char ch =0;
        int i = 1+(int)(Math.random()*4);
        switch (i){
            case 1:if (bigLathin)
                ch = generateBigLatin();
                break;
            case 2:if (lathin)
                ch = generateSmallLatin();
                break;
            case 3:if (numbers)
                ch = generateNumber();
                break;
            case 4:if (specSimvol)
                ch = generateSpecSymbol();
                break;
        }
        return ch;
    }
    private char requiredGenerate(){
        char ch = 0;
        ArrayList<Character> typeSymbol = new ArrayList();
        if(!haveNumber) typeSymbol.add('N');
        if(!haveBigLatin) typeSymbol.add('B');
        if(!haveSmallLatin) typeSymbol.add('s');
        if(!haveSpecSymbol) typeSymbol.add('S');
        int i = (int)(Math.random()* typeSymbol.size());
        switch (typeSymbol.get(i)){
            case 'N':
                ch =generateNumber();
                break;
            case 'B':
                ch = generateBigLatin();
                break;
            case 's':
                ch = generateSmallLatin();
                break;
            case 'S':
                ch = generateSpecSymbol();
                break;
        }
        return ch;
    }
}