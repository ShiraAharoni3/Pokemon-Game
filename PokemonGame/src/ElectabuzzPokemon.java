public class ElectabuzzPokemon extends ElectricsPokemons
{

    static final int THUNDER_COST = 60; //Minimum age requirement
    static final int THUNDER_PUNCH_COST = 80; //Minimum age requirement
    static final int MAX_LIFE_POINT1 = 30;
    static final int MAX_ATTACK_POINT1 = 100;
    static final int MAX_LIFE_POINT2 = 35;
    static final int MAX_ATTACK_POINT2 = 120;
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
                    this.Name = " Electivire` " ;
                    System.out.printf( "name - %s \n",this.Name);
                    System.out.printf( "level- %d \n", this.level);
                    System.out.printf( "attack point- %d \n",this.attackPoints );
                    System.out.printf( "life point- %d \n", this.maxLifePoints);
                }
                else
                {
                    System.out.println(" You don't have enough points to level up ");
                }
                break;

            case 2:
                System.out.println(" You are at the highest level ");
        }
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
                    System.out.printf( "name - %s \n",this.Name);
                    System.out.printf( "level- %d \n", this.level);
                    System.out.printf( "attack point- %d \n",this.attackPoints );
                    System.out.printf( "life point- %d \n", this.maxLifePoints);
                }

                break;
            case 2:
                if ((this.maxLifePoints != MAX_LIFE_POINT2) && (this.attackPoints != MAX_ATTACK_POINT2))
                {
                    this.maxLifePoints = MAX_LIFE_POINT2;
                    this.attackPoints = MAX_ATTACK_POINT2;
                    System.out.printf( "name - %s \n",this.Name);
                    System.out.printf( "level- %d \n", this.level);
                    System.out.printf( "attack point- %d \n",this.attackPoints );
                    System.out.printf( "life point- %d \n", this.maxLifePoints);
                }

                break;
        }
    }
    boolean res = false ;

    public boolean attack()
    {
        switch (this.level)
        {

            case 1:
                if (this.attackPoints >= THUNDER_COST)
                {
                    this.attackPoints -=  THUNDER_COST ;
                    this.damageToTheOpponent = (int) (Math.random() * (50 - 40 + 1) + 50);
                    if ( bonus == true)
                        this.damageToTheOpponent = (this.damageToTheOpponent * 3) ;
                    res = true ;
                }

                break;

            case 2:
                if (this.attackPoints >= THUNDER_PUNCH_COST)
                {
                    this.attackPoints -= THUNDER_PUNCH_COST;
                    this.damageToTheOpponent = (int) (Math.random() * (120 - 50 + 1) + 50);
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

    public boolean attacked( int damagePoint)
    {
        switch (this.level) {
            case 1:
                if (this.maxLifePoints == 0)
                    res = false;
                if (this.maxLifePoints >= damagePoint)
                {
                    this.maxLifePoints -= damagePoint;
                    if ( this.maxLifePoints <= (int) (MAX_LIFE_POINT1 * 0.2) )
                    {
                     this.maxLifePoints = 0 ;
                     res = false ;
                    }
                }
                else
                    this.maxLifePoints = 0;
                    res = true;
                    break;
            case 2:

                if (this.maxLifePoints == 0)
                    res = false;
                if (this.maxLifePoints >= damagePoint)
                {
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
        }
        System.out.printf( "name - %s \n",this.Name);
        System.out.printf( "level- %d \n", this.level);
        System.out.printf( "attack point- %d \n",this.attackPoints );
        System.out.printf( "life point- %d \n", this.maxLifePoints);
        return res;
    }


    ElectabuzzPokemon()
    {
        super();
        this.Name = "ElectabuzzPokemon ";
        this.level= 1 ;
        this.maxLifePoints = MAX_LIFE_POINT1;
        this.attackPoints = 75 ;
        this.costAttack = THUNDER_COST ;
        System.out.printf( "Pokemon  Electabuzz has \n");
        System.out.printf( "name - %s \n",this.Name);
        System.out.printf( "level- %d \n", this.level);
        System.out.printf( "attack point- %d \n",this.attackPoints );
        System.out.printf( "life point- %d \n", this.maxLifePoints);
        System.out.printf( "your cost attack- %d \n",this.costAttack );
    }
}
