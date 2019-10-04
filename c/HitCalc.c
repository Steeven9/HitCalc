#include <stdio.h>
#include <stdlib.h>

int main(int argc, const char * argv[]) {
    int ac = atoi(argv[1]);
    int mod = atoi(argv[2]);

    double probHit = 20 - ac + mod + 1;
    probHit /= 20;  //fix to prevent integer division
    double probMiss = ac - mod - 1;
    probMiss /= 20;

    double resultAdv = 1 - (probMiss * probMiss);
    double resultDis = probHit * probHit;

    if (probHit <= 0) {
        printf("Impossible to hit, unless you roll a 20\n");
    } else if (probHit >= 1) {
        printf("Guaranteed hit, unless you roll a 1\n");
    } else {
        printf("Enemy's AC: %d - Mod: %d\nNormal hit rate: %g\nAdvantage: %g - Disadvantage: %g\n", 
            ac, mod, probHit, resultAdv, resultDis);
    }
}