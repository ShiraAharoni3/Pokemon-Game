public class PikachuPokemon extends ElectricsPokemons
{

    static final int QUICK_ATTACK_COST = 5;
    static final int ELECTRO_BALL_COST = 10;
    static final int ELECTRIC_SURFER_COST = 60;
    static final int MAX_LIFE_POINT1 = 40;
    static final int MAX_ATTACK_POINT1 = 30;
    static final int MAX_LIFE_POINT2 = 50;
    static final int MAX_ATTACK_POINT2 = 40;
    static final int MAX_LIFE_POINT3 = 160;
    static final int MAX_ATTACK_POINT3 = 80;
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
                    case 3:
                        if (this.maxLifePoints > MAX_LIFE_POINT3 )

                            maxLifePoints = MAX_LIFE_POINT3 ;

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
                    case 3:
                        if (this.attackPoints > MAX_ATTACK_POINT3 )
                            maxLifePoints = MAX_ATTACK_POINT3 ;

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
                    this.Name = " Pikachu" ;
                }
                else
                {
                    System.out.println(" You don't have enough points to level up ");
                }
                break;

            case 2:
                if ((this.maxLifePoints >= LIFE_POINT_TO_LEVEL_UP3) && (this.attackPoints >= ATTACK_POINT_TO_LEVEL_UP3))
                {
                    this.level = 3;
                    this.Name = " Raichu ";
                }
                else
                {
                    System.out.println(" You don't have enough points to level up ");
                }
                break;

            case 3:
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
            case 3:
                if ((this.maxLifePoints != MAX_LIFE_POINT3) && (this.attackPoints != MAX_ATTACK_POINT3))
                {
                    this.maxLifePoints = MAX_LIFE_POINT3;
                    this.attackPoints = MAX_ATTACK_POINT3;
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
                if (this.attackPoints >= QUICK_ATTACK_COST)
                {
                    this.attackPoints -= QUICK_ATTACK_COST ;
                    this.damageToTheOpponent = 10 ;
                    res = true;
                }
                break;

            case 2:
                if (this.attackPoints >= ELECTRO_BALL_COST )
                {
                    this.attackPoints -= ELECTRO_BALL_COST  ;
                    this.damageToTheOpponent =  (int) (Math.random() * (40 - 30 + 1) + 30);
                    if ( bonus == true)
                        this.damageToTheOpponent = (this.damageToTheOpponent * 3) ;
                    res = true;
                }
                break;

            case 3:
                if (this.attackPoints >= ELECTRIC_SURFER_COST)
                {
                    this.attackPoints -= ELECTRIC_SURFER_COST ;
                    this.damageToTheOpponent = (int) (Math.random() * (120 - 20 + 1) + 20);
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
                    if ( this.maxLifePoints <= (int) (MAX_LIFE_POINT1 * 0.2) )
                    {
                        this.maxLifePoints = 0 ;
                        res = false ;
                    }
                } else
                    this.maxLifePoints = 0;
                    res = true;
                    break;
            case 2:


                if (this.maxLifePoints == 0)
                    res = false;
                if (this.maxLifePoints >= damagePoint) {
                    this.maxLifePoints -= damagePoint;
                    if ( this.maxLifePoints <= (int) (MAX_LIFE_POINT2 * 0.2) )
                    {
                        this.maxLifePoints = 0 ;
                        res = false ;
                    }
                }
                else
                    this.maxLifePoints = 0;
                    res = true;
                    break;

            case 3:
                if (this.maxLifePoints == 0)
                    res = false;
                if (this.maxLifePoints >= damagePoint)
                {
                    this.maxLifePoints -= damagePoint;
                    if ( this.maxLifePoints <= (int) (MAX_LIFE_POINT3 * 0.2) )
                    {
                        this.maxLifePoints = 0 ;
                        res = false ;
                    }
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


    PikachuPokemon( )
    {
        super();
        this.Name = "PikachuPokemon ";
        this.level= 1 ;
        this.maxLifePoints = MAX_LIFE_POINT1;
        this.attackPoints = 22 ;
        this.costAttack = QUICK_ATTACK_COST ;
        System.out.printf( "Pokemon Pikachu has \n");
        System.out.printf( "name - %s \n",this.Name);
        System.out.printf( "level- %d \n", this.level);
        System.out.printf( "attack point- %d \n",this.attackPoints );
        System.out.printf( "life point- %d \n", this.maxLifePoints);
        System.out.printf( "your cost attack- %d \n",this.costAttack );
    }

}
