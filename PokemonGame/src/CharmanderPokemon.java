import java.util.Random;

public class CharmanderPokemon extends FiresPokemons
{
    static final int SCRATCH_COST = 15;
    static final int FLAME_TAIL_COST = 40;
    static final int FIERY_BLAST_COST = 50;
    static final int MAX_LIFE_POINT1 = 80;
    static final int MAX_ATTACK_POINT1 = 40;
    static final int MAX_LIFE_POINT2 = 90;
    static final int MAX_ATTACK_POINT2 = 60;
    static final int MAX_LIFE_POINT3 = 130;
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
        int res = 0 ;
        switch (this.level)
        {

            case 1:
                if ((this.maxLifePoints >= LIFE_POINT_TO_LEVEL_UP2) && (this.attackPoints >= ATTACK_POINT_TO_LEVEL_UP2))
                {
                    this.level = 2;
                    this.Name = " Charmeleon" ;
                    System.out.printf( "name - %s \n",this.Name);
                    System.out.printf( "level- %d \n", this.level);
                    System.out.printf( "attack point- %d \n",this.attackPoints );
                    System.out.printf( "life point- %d \n", this.maxLifePoints);
                    break;
                }
                else
                {
                    System.out.println(" You don't have enough points to level up ");
                    res = - 1 ;
                    break;
                }

            case 2:
                if ((this.maxLifePoints >= LIFE_POINT_TO_LEVEL_UP3) && (this.attackPoints >= ATTACK_POINT_TO_LEVEL_UP3))
                {
                    this.level = 3;
                    this.Name = " Charizard ";
                    System.out.printf( "name - %s \n",this.Name);
                    System.out.printf( "level- %d \n", this.level);
                    System.out.printf( "attack point- %d \n",this.attackPoints );
                    System.out.printf( "life point- %d \n", this.maxLifePoints);
                    break;
                }
                else
                {
                    System.out.println(" You don't have enough points to level up ");
                    res = -1;
                    break;
                }

            case 3:
                System.out.println(" You are at the highest level ");
                res = -1 ;
                break;
        }
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
                        String Attack = "Scratch " ;
                            this.maxLifePoints = (this.maxLifePoints /2) ;
                            this.attackPoints = 0 ;
                        }
                        break;
                    case 2:
                       String Attack ;
                       int number = random.nextInt(1 ,3) ;
                       if(number == 1)
                       {
                           Attack = "Scratch ";
                           this.maxLifePoints = (this.maxLifePoints /2) ;
                           this.attackPoints = 0 ;
                       }
                       else
                       {
                           Attack = " Flame Tail" ;
                           this.maxLifePoints = (this.maxLifePoints /2) ;
                           this.attackPoints = 0 ;
                        }
                        break;
                    case 3:
                        int number1 = random.nextInt(1 ,4) ;
                        if(number1 == 1)
                        {
                            Attack = "Scratch ";
                            this.maxLifePoints = (this.maxLifePoints /2) ;
                            this.attackPoints = 0 ;
                        }
                        else if ( number1 == 2 )
                        {
                            Attack = " Flame Tail" ;
                            this.maxLifePoints = (this.maxLifePoints /2) ;
                            this.attackPoints = 0 ;
                        }
                        else
                        {
                            Attack = " Fiery Blast " ;
                            this.maxLifePoints = (this.maxLifePoints /2) ;
                            this.attackPoints = 0 ;
                        }
                        break;
                }
            }

    boolean res = false ;
    public boolean attack()
    {
        Random random = new Random();
        switch (this.level) {
            case 1:
                if (this.attackPoints >= SCRATCH_COST) {
                    this.attackPoints -= SCRATCH_COST;
                    this.maxLifePoints -= AttackerPokemon();
                    this.damageToTheOpponent = (int) (Math.random() * (30 - 25 + 1) + 25);
                    if ( bonus == true)
                        this.damageToTheOpponent = (this.damageToTheOpponent * 3) ;
                    res = true;
                }
                break;
            case 2:
                if (this.attackPoints >= FLAME_TAIL_COST) {
                    this.attackPoints -= FLAME_TAIL_COST;
                    this.maxLifePoints -= AttackerPokemon();
                    this.damageToTheOpponent = (int) (Math.random() * (50 - 30 + 1) + 30);
                    if ( bonus == true)
                        this.damageToTheOpponent = (this.damageToTheOpponent * 3) ;
                    res = true;
                }
                break;
            case 3:
                if (this.attackPoints >= FIERY_BLAST_COST)
                {
                    this.attackPoints -= FIERY_BLAST_COST;
                    this.maxLifePoints -= AttackerPokemon();
                    this.damageToTheOpponent = 50;
                    if ( bonus == true)
                        this.damageToTheOpponent = (this.damageToTheOpponent * 3) ;
                    res = true;
                }
                break;
            default:
                break;
        }
        System.out.printf("name - %s \n", this.Name);
        System.out.printf("level- %d \n", this.level);
        System.out.printf("attack point- %d \n", this.attackPoints);
        System.out.printf("life point- %d \n", this.maxLifePoints);
        return res ;
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
                }
                else
                    this.maxLifePoints = 0;

                res = true;
                break;
            case 2:
                if (this.maxLifePoints == 0)
                    res = false;
                if (this.maxLifePoints >= damagePoint) {
                    this.maxLifePoints -= damagePoint;
                }
                else
                res = true;
                break;
            case 3:
                if (this.maxLifePoints == 0)
                    res = false;
                if (this.maxLifePoints >= damagePoint)
                    this.maxLifePoints -= damagePoint;
                else
                res = true;
                break;

        }
        this.maxLifePoints = 0;

        System.out.printf( "name - %s \n",this.Name);
        System.out.printf( "level- %d \n", this.level);
        System.out.printf( "attack point- %d \n",this.attackPoints );
        System.out.printf( "life point- %d \n", this.maxLifePoints);
        return res;
    }


        CharmanderPokemon()
        {
            super();
            this.Name = "CharmanderPokemon ";
            this.level= 1 ;
            this.maxLifePoints = MAX_LIFE_POINT1;
            this.attackPoints = 30 ;
            this.costAttack = SCRATCH_COST ;
            System.out.printf( "Pokemon Charmander has \n");
            System.out.printf( "name - %s \n",this.Name);
            System.out.printf( "level- %d \n", this.level);
            System.out.printf( "attack point- %d \n",this.attackPoints );
            System.out.printf( "life point- %d \n", this.maxLifePoints);
            System.out.printf( "your cost attack- %d \n",this.costAttack );

        }
    }
