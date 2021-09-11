"""
준규가 가지고 있는 동전은 총 N종류이고, 각각의 동전을 매우 많이 가지고 있다.
동전을 적절히 사용해서 그 가치의 합을 K로 만들려고 한다. 이때 필요한 동전 개수의 최솟값을 구하는 프로
그램을 작성하시오

입력 : 첫째 줄에 N과 K가 주어진다. (1 ≤ N ≤ 10, 1 ≤ K ≤ 100,000,000)
        둘째 줄부터 N개의 줄에 동전의 가치 Ai
        가 오름차순으로 주어진다. (1 ≤ Ai ≤ 1,000,000, A1 = 1, i ≥ 2인 경우에 Ai
        는 Ai-1
        의 배수)

출력 : 첫째 줄에 K원을 만드는데 필요한 동전 개수의 최솟값을 출력한다.

"""
first_line = input()

n = int(first_line.split(' ')[0])
change = int(first_line.split(' ')[1])
coins = []
last_coin = 0
for i in range(0,n) :

    input_coin = int(input())
    if i == 0 :
        coins.append(input_coin)
        last_coin = input_coin
    else:
        if input_coin % last_coin != 0:
            exit(-1);
        else:
            coins.append(input_coin)
            last_coin = input_coin


count = 0

i = coins.__len__() - 1
while(i >= 0) :
    count += int(change / coins[i])
    change = change % coins[i]
    i -= 1


print(count)
        
