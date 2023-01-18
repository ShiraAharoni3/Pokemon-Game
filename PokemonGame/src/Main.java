import java.util.Random;
import java.util.Scanner ;
import java.util.concurrent.TimeUnit;

public class Main
{
    enum Action {
        NONE,
        ATTACKED ,
        UP_LEVEL_FAIL  ;

    }

    boolean specialOperationCount = false ;
    public static void delay(long period) {
        try {
            TimeUnit.SECONDS.sleep((long) period);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

    }


    public static  Pokemon getPokemon() {
        Pokemon player = null ;
        Random random = new Random();
        String pokemon = " ";
        int numberOfPokemon = random.nextInt(1, 7);
        switch (numberOfPokemon) {
            case 1:
                player = new CharmanderPokemon();
                break;
            case 2:
                player = new SalanditPokemon();
                break;
            case 3:
                player = new MoltresPokemon();
                break;
            case 4:
                player = new PikachuPokemon();
                break;
            case 5:
                player = new BlitzlePokemon();
                break;
            case 6:
                player = new ElectabuzzPokemon();
                break;


        }
        return player ;

    }
    public static Action pokemonTurn( Pokemon player )
    {
        Action attacked = Action.NONE;
        Scanner scanner = new Scanner( System.in );
        int playerChoice = 0;
        System.out.printf( " %s it is your turn", player.Name);
        System.out.printf(" Please chose one's options : \n");
        System.out.printf("1- Attack \n2- Waiting \n3- Develop \n4- Special action");
        System.out.printf("enter your choice from the menu \n");
        playerChoice = scanner.nextInt();
        switch (playerChoice)
        {
            case 1:
                player.attack();
                attacked = Action.ATTACKED ;
                break;
            case 2:
                player.waitingPock();
                // waiting method
                break;
            case 3:
                if( player.upLevel() == -1 )
                    attacked = Action.UP_LEVEL_FAIL ;
                // Up Level method
                break;
            case 4:
                player.specialAction();
                // Special action method
                break;
            default :
                break;
        }
        return attacked ;
    }

    public static void main(String[] args)
    {
        Pokemon player1  = null ;
        Pokemon player2  = null ;
        char user_choice = 0;
        System.out.printf("Hello welcome to Pokemon World \n");
        System.out.printf("Enter 1 to start new game q to exit \n");
        Scanner scanner = new Scanner(System.in);
        user_choice = (char) scanner.nextByte();
        if (user_choice == 'q')
        {
            System.out.printf("Game over  \n");
            delay(2);
        }
        else
        {
            System.out.printf("Player 1 press enter to get pokemon \n");
            player1 = getPokemon();
            System.out.printf("Player 2 pres enter to get pokemon \n");
            player2 = getPokemon();
//            Pokemon playerTurn = player1;
//            Pokemon playerAttacked = player2 ;
            int turn = 0 ;
            boolean turn_over = true ;
            Action action = Action.NONE;
            while ((player1.maxLifePoints != 0) && (player2.maxLifePoints != 0))
            {
                if( turn == 0 )
                {
                    action =  pokemonTurn(player1);
                    if( action == Action.ATTACKED )

                        player2.attacked(player1.damageToTheOpponent);
                    else if ( action == Action.UP_LEVEL_FAIL )
                        turn_over = false ;
                    player1.additionLifePointToPlayer(player1);
                    player1.additionAttackPointToPlayer(player1);

                }
                else
                {
                    action =  pokemonTurn(player2);
                    if( action == Action.ATTACKED )
                        player1.attacked( player2.damageToTheOpponent );
                    else if ( action == Action.UP_LEVEL_FAIL )
                        turn_over = false ;
                    player2.additionLifePointToPlayer(player2);
                    player2.additionAttackPointToPlayer(player2);

                }

                if( turn_over == true )
                    turn = (turn == 1 ) ? 0 : 1 ;
            }
            if ( player1.maxLifePoints == 0 )
                System.out.printf( " the game over pokemon %s win" ,player1.Name);
            else
            {
                System.out.printf(" the game over pokemon %s win", player2.Name);
            }

        }

    }
}