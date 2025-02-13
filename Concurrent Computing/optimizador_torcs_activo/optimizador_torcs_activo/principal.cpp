// Compilar con:

/* INSTALAR LA BIBLIOTECA fmt PARA PODER COMPILAR SIN PROBLEMAS. */


// VERSION SECUENCIAL:
// $> g++ -I./problemas/ ./problemas/*.cpp *.cpp -lfmt -o genetico

// VERSION CONCURRENTE CON MPI:
// $> mpic++ -I./problemas/ ./problemas/*.cpp *.cpp -lfmt -o genetico

#include <iostream>
#include <mpi.h>
#include "GeneticoSimple.h"
#include "TorcsFun.h"
#include "CannonFun.h"

using namespace std;

int main( int argc, char *argv [] )
{
   
   MPI_Init( &argc, &argv );
   /*
    * Para la versión secuencial se usa serverID=0, PERO
    * para la versión concurrente serverID debe ser igual a myRank.
    */
   int serverID;

   MPI_Comm_rank(MPI_COMM_WORLD, &serverID);
   /* Aquí se crea la instancia de TorcsFun con el serverID indicado. */
   ProblemaOptim* problema = new TorcsFun(serverID);
   

   /* Para usar el problema del Controlador del Auto en TORCS
    * deben descomentar la línea de arriba y comentar la de abajo.
    */

   /* Con esta instancia se resolverá el problema del cañón. */
   //ProblemaOptim* problema = new CannonFun();


   /* La descripción de estos valores está en GeneticoSimple.h */

   /*
   ParamsGA pars = {popSize, Gmax, Pc, Pm, precision, nMigrantes, tamEpoca,};*/

   ParamsGA pars = {36, 30, 0.9, 0.1, 6, 6, 6,};

   //ParamsGA pars = {8, 4, 0.9, 0.1, 6, 4, 3,};

   //ParamsGA pars = {8, 10, 0.9, 0.1, 6, 4, 3,};

   GeneticoSimple ga(problema, pars);
   ga.optimizar();
   MPI_Finalize();

   delete problema;


   return 0;
}
