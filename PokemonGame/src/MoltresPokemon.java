import java.util.Random;
import java.util.Scanner;

public class MoltresPokemon extends FiresPokemons
{
    static final int ASSISTING_HEATER_COST = 30;
    static final int FIRE_WING_COST = 30;
    static final int MAX_LIFE_POINT = 120;
    static final int MAX_ATTACK_POINT = 60;
    public void waitingPock()
    {
        int bonus = (int) (Math.random() * (3 - 1 + 1) + 1);

        switch (bonus)
        {
            case 1:
                int b1 = (int) (Math.random() * (30 - 5 + 1) + 5);
                System.out.printf( " you get more %d life point \n " , b1);
                this.maxLifePoints += b1 ;
                if (this.maxLifePoints > MAX_LIFE_POINT )
                        maxLifePoints = MAX_LIFE_POINT ;
                break;

            case 2:
                int b2 = (int) (Math.random() * (40 - 0 + 1) + 40);
                System.out.printf( " you get more %d attack point \n " , b2);
                this.attackPoints += b2 ;
                if (this.attackPoints > MAX_ATTACK_POINT )
                     maxLifePoints = MAX_ATTACK_POINT ;
                break;
        }
    }

    public int upLevel()
    {
        System.out.println(" You are at the highest level ");
        return -1 ;
    }

    public void specialAction()
    {
        {
            Random random = new Random();
            String Attack ;
            int number = random.nextInt(1 ,3) ;
            if(number == 1)
            {
                Attack = "Assisting heater ";
                this.maxLifePoints = (this.maxLifePoints /2) ;
                this.attackPoints = 0 ;
            }
            else
            {
                Attack = " Fire Wing" ;
                this.maxLifePoints = (this.maxLifePoints /2) ;
                this.attackPoints = 0 ;
            }
            System.out.printf( "name - %s \n",this.Name);
            System.out.printf( "level- %d \n", this.level);
            System.out.printf( "attack point- %d \n",this.attackPoints );
            System.out.printf( "life point- %d \n", this.maxLifePoints);
        }
    }

    boolean res = false ;

    public boolean attack()
    {
        int attackSelection ;
        Scanner scanner = new Scanner(System.in);
        System.out.println( " Please enter your attack selection : ");
        attackSelection = scanner.nextInt();
        if (this.attackPoints >= 30)
          {
            int choseAttack = 0 ;
            System.out.println( " please chose kind of attack :");
            System.out.println( " 1 - Fire Wing ");
            System.out.println( " 2 - Assisting Heater ");
            choseAttack = scanner.nextInt();
            switch ( choseAttack )
            {
                case 1:
                    this.maxLifePoints -= AttackerPokemon () ;
                    this.attackPoints -= FIRE_WING_COST ;
                    this.damageToTheOpponent = 30 ;
                    if ( bonus == true)
                        this.damageToTheOpponent = (this.damageToTheOpponent * 3) ;
                    res = true;
                    break;

                case 2:
                    this.maxLifePoints -= AttackerPokemon () ;
                    this.attackPoints -= ASSISTING_HEATER_COST ;
                    this.damageToTheOpponent = (int) (Math.random() * (60 - 10 + 1) + 10);
                    if ( bonus == true)
                        this.damageToTheOpponent = (this.damageToTheOpponent * 3) ;
                    res = true;
                    break;


            }

         }
        else
         {
            res = false ;
         }
        System.out.printf( "name - %s \n",this.Name);
        System.out.printf( "level- %d \n", this.level);
        System.out.printf( "attack point- %d \n",this.attackPoints );
        System.out.printf( "life point- %d \n", this.maxLifePoints);
        return res ;
    }

    public boolean attacked( int damagePoint)
    {
        switch (this.level) {
            case 1:


                if (this.maxLifePoints == 0)
                    res = false;
                if (this.maxLifePoints >= damagePoint) {
                    this.maxLifePoints -= damagePoint;
                } else
                    this.maxLifePoints = 0;
                res = true;
                break;
            case 2:
                damagePoint = 30 ;

                if (this.maxLifePoints == 0)
                    res = false;
                if (this.maxLifePoints >= damagePoint) {
                    this.maxLifePoints -= damagePoint;
                } else
                    this.maxLifePoints = 0;

                res = true;
                break;
        }
        System.out.printf( "name - %s \n",this.Name);
        System.out.printf( "level- %d \n", this.level);
        System.out.printf( "attack point- %d \n",this.attackPoints );
        System.out.printf( "life point- %d \n", this.maxLifePoints);
        return res;
    }



    MoltresPokemon( )
    {

        super();
        this.Name = "MoltresPokemon ";
        this.level= 1 ;
        this.maxLifePoints = MAX_LIFE_POINT;
        this.attackPoints = 45 ;
        this.costAttack = ASSISTING_HEATER_COST ;
        System.out.printf( "Pokemon Moltres has \n");
        System.out.printf( "name - %s \n",this.Name);
        System.out.printf( "level- %d \n", this.level);
        System.out.printf( "attack point- %d \n",this.attackPoints );
        System.out.printf( "life point- %d \n", this.maxLifePoints);
        System.out.printf( "your cost attack- %d \n",this.costAttack );

    }
}
