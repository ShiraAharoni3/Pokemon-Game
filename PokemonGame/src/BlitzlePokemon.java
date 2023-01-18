import java.util.Random;

public class BlitzlePokemon extends ElectricsPokemons
{
    static final int FLOP_COST = 20;
    static final int ZAP_KICK_COST = 30;
    static final int MAX_LIFE_POINT1 = 90;
    static final int MAX_ATTACK_POINT1 = 35;
    static final int MAX_LIFE_POINT2 = 100;
    static final int MAX_ATTACK_POINT2 = 50;
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
    }

    public int upLevel()
    {
        switch (this.level)
        {

            case 1:
                if ((this.maxLifePoints >= LIFE_POINT_TO_LEVEL_UP2) && (this.attackPoints >= ATTACK_POINT_TO_LEVEL_UP2))
                {
                    this.level = 2;
                    this.Name = " Zebstrika " ;

                    break;
                }
                else
                {
                    System.out.println(" You don't have enough points to level up ");
                    break;
                }

            case 2:
                System.out.println(" You are at the highest level ");
                break;
        }
        System.out.printf( "name - %s \n",this.Name);
        System.out.printf( "level- %d \n", this.level);
        System.out.printf( "attack point- %d \n",this.attackPoints );
        System.out.printf( "life point- %d \n", this.maxLifePoints);
        return 0;
    }

    public void specialAction()
    {
        switch (this.level)
        {
            case 1:
                if ((this.maxLifePoints <= MAX_LIFE_POINT1) && (this.attackPoints <= MAX_ATTACK_POINT1))
                {
                    this.maxLifePoints = MAX_LIFE_POINT1;
                    this.attackPoints = MAX_ATTACK_POINT1;

                }
                break;
            case 2:
                if ((this.maxLifePoints != MAX_LIFE_POINT2) && (this.attackPoints != MAX_ATTACK_POINT2))
                {
                    this.maxLifePoints = MAX_LIFE_POINT2;
                    this.attackPoints = MAX_ATTACK_POINT2;

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
        Random random = new Random();
        switch (this.level)
        {

            case 1:
                if (this.attackPoints >= FLOP_COST)
                {
                    this.attackPoints -= FLOP_COST ;
                    this.damageToTheOpponent = (int) (Math.random() * (25 - 20 + 1) + 20) ;
                    if ( bonus == true)
                        this.damageToTheOpponent = (this.damageToTheOpponent * 3) ;
                    res = true;
                }
                break;

            case 2:
                if (this.attackPoints >= ZAP_KICK_COST)
                {
                    this.attackPoints -= ZAP_KICK_COST ;
                    this.damageToTheOpponent = (int) (Math.random() * (35 - 30 + 1) + 30);
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
        switch (level)
        {
            case 1:
                //int damagePoint;
                //damagePoint = (int) (Math.random() * (25 - 20 + 1) + 20) ;

                if (this.maxLifePoints == 0)
                    res = false;
                if (this.maxLifePoints >= damagePoint)
                {
                    this.maxLifePoints -= damagePoint;
                    if (this.maxLifePoints <= (int) (MAX_LIFE_POINT1 * 0.2))
                    {
                        this.maxLifePoints = 0;
                        res = false;
                    }
                    else
                        this.maxLifePoints = 0;
                        res = true;
                }
                    break;
            case 2:
                if (this.maxLifePoints == 0)
                    res = false;
                if (this.maxLifePoints >= damagePoint) {
                    this.maxLifePoints -= damagePoint;
                    if ( this.maxLifePoints <= (int) (MAX_LIFE_POINT1 * 0.2) )
                    {
                        this.maxLifePoints = 0 ;
                        res = false ;
                    }
                }
                else
                    res = true;
                    break;
        }

        System.out.printf( "name - %s \n",this.Name);
        System.out.printf( "level- %d \n", this.level);
        System.out.printf( "attack point- %d \n",this.attackPoints );
        System.out.printf( "life point- %d \n", this.maxLifePoints);
        return res;
    }


    BlitzlePokemon( )
    {
        super();
        this.Name = "BlitzlePokemon ";
        this.level= 1 ;
        this.maxLifePoints = MAX_LIFE_POINT1;
        this.attackPoints = 26 ;
        this.costAttack = FLOP_COST ;
        System.out.printf( "Pokemon  Blitzle has \n");
        System.out.printf( "name - %s \n",this.Name);
        System.out.printf( "level- %d \n", this.level);
        System.out.printf( "attack point- %d \n",this.attackPoints );
        System.out.printf( "life point- %d \n", this.maxLifePoints);
        System.out.printf( "your cost attack- %d \n",this.costAttack );
    }



}
