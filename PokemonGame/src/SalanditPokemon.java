import java.util.Random;

public class SalanditPokemon extends FiresPokemons
{

    static final int LIVE_COAL_COST = 10;
    static final int FIRE_CLAWS_COST = 25;
    static final int MAX_LIFE_POINT1 = 100;
    static final int MAX_ATTACK_POINT1 = 60;
    static final int MAX_LIFE_POINT2 = 160;
    static final int MAX_ATTACK_POINT2 = 80;
    public void waitingPock()
    {
        int bonus = (int) (Math.random() * (3 - 1 + 1) + 1);

        switch (bonus)
        {
            case 1:
                int b1 = (int) (Math.random() * (30 - 5 + 1) + 5);
                System.out.printf( " you get more %d life point \n " , b1);
                this.maxLifePoints += b1 ;
                switch (this.level)
                {
                    case 1:
                        if (this.maxLifePoints > MAX_LIFE_POINT1 )
                            maxLifePoints = MAX_LIFE_POINT1 ;

                        break;
                    case 2:
                        if (this.maxLifePoints > MAX_LIFE_POINT2 )

                            maxLifePoints = MAX_LIFE_POINT2 ;

                        break;
                }
                break;

            case 2:
                int b2 = (int) (Math.random() * (40 - 0 + 1) + 40);
                System.out.printf( " you get more %d attack point \n " , b2);
                this.attackPoints += b2 ;
                switch (this.level)
                {
                    case 1:
                        if (this.attackPoints > MAX_ATTACK_POINT1 )
                            maxLifePoints = MAX_ATTACK_POINT1 ;

                        break;
                    case 2:
                        if (this.attackPoints > MAX_ATTACK_POINT2 )
                            maxLifePoints = MAX_ATTACK_POINT2 ;

                        break;
                }
                break;

            case 3:
                System.out.println( " you get triple attack next turn \n ");
                this.bonus = true ;
                break;

        }
        System.out.printf( "name - %s \n",this.Name);
        System.out.printf( "level- %d \n", this.level);
        System.out.printf( "attack point- %d \n",this.attackPoints );
        System.out.printf( "life point- %d \n", this.maxLifePoints);
    }

    public int upLevel()
    {
        int res = 0 ;
        switch (this.level)
        {

            case 1:
                if ((this.maxLifePoints >= LIFE_POINT_TO_LEVEL_UP2) && (this.attackPoints >= ATTACK_POINT_TO_LEVEL_UP2))
                {
                    this.level = 2;
                    this.Name = " Salazzle" ;
                }
                else
                {
                    res = -1 ;
                    System.out.println(" You don't have enough points to level up ");
                }
                break;

            case 2:
                res = -1 ;
                System.out.println(" You are at the highest level ");
                break;
        }
        System.out.printf( "name - %s \n",this.Name);
        System.out.printf( "level- %d \n", this.level);
        System.out.printf( "attack point- %d \n",this.attackPoints );
        System.out.printf( "life point- %d \n", this.maxLifePoints);
        return res;
    }


    public void specialAction()
    {
        Random random = new Random();
        switch (this.level)
        {
            case 1:
                switch (this.level)
                {
                    case 1:
                        String Attack = "Live Coal " ;
                        this.maxLifePoints = (this.maxLifePoints /2) ;
                        this.attackPoints = 0 ;
                }
                break;
            case 2:
                String Attack ;
                int number = random.nextInt(1 ,3) ;
                if(number == 1)
                {
                    Attack = "Live Coal ";
                    this.maxLifePoints = (this.maxLifePoints /2) ;
                    this.attackPoints = 0 ;
                }
                else
                {
                    Attack = " Fire Claws" ;
                    this.maxLifePoints = (this.maxLifePoints /2) ;
                    this.attackPoints = 0 ;
                }
                break;
        }
        System.out.printf( "name - %s \n",this.Name);
        System.out.printf( "level- %d \n", this.level);
        System.out.printf( "attack point- %d \n",this.attackPoints );
        System.out.printf( "life point- %d \n", this.maxLifePoints);
    }

    boolean res = false ;

    public boolean attack()
    {
        switch (this.level)
        {

            case 1:
                if (this.attackPoints >= LIVE_COAL_COST)
                {
                    this.attackPoints -= AttackerPokemon ();
                    this.maxLifePoints -= LIVE_COAL_COST ;
                    this.damageToTheOpponent = (int) (Math.random() * (25 - 0 + 1) + 0);
                    if ( bonus == true)
                        this.damageToTheOpponent = (this.damageToTheOpponent * 3) ;
                    res = true;
                }
                break;

            case 2:
                if (this.attackPoints >= FIRE_CLAWS_COST)
                {
                    this.maxLifePoints -= AttackerPokemon () ;
                    this.attackPoints -= FIRE_CLAWS_COST ;
                    this.damageToTheOpponent = (int) (Math.random() * (50 - 0 + 1) + 0);
                    if ( bonus == true)
                        this.damageToTheOpponent = (this.damageToTheOpponent * 3) ;
                    res = true;
                }
                break;
            default:
                break;
        }
        System.out.printf( "name - %s \n",this.Name);
        System.out.printf( "level- %d \n", this.level);
        System.out.printf( "attack point- %d \n",this.attackPoints );
        System.out.printf( "life point- %d \n", this.maxLifePoints);
        return res;
    }

    public boolean attacked( int damagePoint )
    {
        switch (this.level) {
            case 1:
                if (this.maxLifePoints == 0)
                    res = false;
                if (this.maxLifePoints >= damagePoint)
                {
                    this.maxLifePoints -= damagePoint;
                } else
                    this.maxLifePoints = 0;
                res = true;
                break;
            case 2:
            {
                if (this.maxLifePoints == 0)
                    res = false;
                if (this.maxLifePoints >= damagePoint) {
                    this.maxLifePoints -= damagePoint;
                } else
                    this.maxLifePoints = 0;
                res = true;
                break;
            }
        }
        System.out.printf( "name - %s \n",this.Name);
        System.out.printf( "level- %d \n", this.level);
        System.out.printf( "attack point- %d \n",this.attackPoints );
        System.out.printf( "life point- %d \n", this.maxLifePoints);
        return res;
    }



    SalanditPokemon( )
    {

        super();
        this.Name = "SalanditPokemon ";
        this.level= 1 ;
        this.maxLifePoints = MAX_LIFE_POINT1;
        this.attackPoints = 45 ;
        this.costAttack = LIVE_COAL_COST ;
        System.out.printf( "Pokemon Salandit has \n");
        System.out.printf( "name - %s \n",this.Name);
        System.out.printf( "level- %d \n", this.level);
        System.out.printf( "attack point- %d \n",this.attackPoints );
        System.out.printf( "life point- %d \n", this.maxLifePoints);
        System.out.printf( "your cost attack- %d \n",this.costAttack );

    }
}
