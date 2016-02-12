using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1
{
    class Program
    {
        static void Main(string[] args)
        {
            var inputList = new List<string>();

            var inputCount = Console.ReadLine();

            var count = 0;
            if(int.TryParse(inputCount , out count))
            {
                for (var i = 0; i < count; i++)
                {
                    inputList.Add(Console.ReadLine());
                }
            }


            foreach (var input in inputList)
            {
                Console.WriteLine(GetNextPalindrome(input));
            }
            Console.ReadLine();

        }
        private static string GetNextPalindrome(string givenNumber)
        {
            givenNumber = givenNumber.TrimStart('0');
            if (givenNumber.Length == 0) givenNumber = "0";
            var givenNumberArray = givenNumber.ToCharArray();

            var carry = false;
            for (var t = givenNumberArray.Length - 1; t >= 0; t--)
            {
                if (t != 0 && givenNumberArray[t] == '9' && givenNumberArray[t - 1] != '9')
                {
                    givenNumberArray[t] = '0';
                    givenNumberArray[t - 1]++;
                    if (carry) carry = false;
                    break;

                }
                else if (givenNumberArray[t] == '9')
                {
                    carry = true;
                    givenNumberArray[t] = '0';
                }
                else
                {
                    givenNumberArray[t]++;
                    break;
                }
            }
            if (carry)
            {

                var s = new string(givenNumberArray);
                s = "1" + s;
                givenNumberArray = s.ToCharArray();
            }

            var length = givenNumberArray.Length;
            int wall = length / 2;
            var increase = false;

            for (int i = 0, j = length - 1; i < wall; i++, j--)
            {
                if (Convert.ToInt32(givenNumberArray[i]) > Convert.ToInt32(givenNumberArray[j]))
                {
                    givenNumberArray[j] = givenNumberArray[i];
                    increase = false;
                }

                else if (Convert.ToInt32(givenNumberArray[i]) < Convert.ToInt32(givenNumberArray[j]))
                {
                    // decrease v(j) to v(i)
                    // set increase to true.. 
                    // note: when increase is over set to false.
                    givenNumberArray[j] = givenNumberArray[i];
                    increase = true;
                }
            }
            var newWall1 = length % 2 == 0 ? wall - 1 : wall;
            var newWall2 = wall;
            if (increase)
            {
                while (givenNumberArray[newWall1] == '9' && givenNumberArray[newWall2] == '9')
                {
                    newWall1 = newWall1 - 1;
                    newWall2 = newWall2 + 1;
                }

                if (givenNumberArray[wall] != '9')
                {
                    if (length % 2 == 0)
                    {
                        givenNumberArray[wall]++;
                        givenNumberArray[wall - 1]++;
                    }
                    else
                    {
                        givenNumberArray[wall]++;
                    }
                }
                else
                {
                    if (length % 2 == 0)
                    {
                        givenNumberArray[newWall1]++;
                        givenNumberArray[newWall2]++;
                    }
                    else
                    {
                        givenNumberArray[newWall1]++;
                        givenNumberArray[newWall2]++;
                    }

                    for (var temp = newWall1 + 1; temp < newWall2; temp++)
                        givenNumberArray[temp] = '0';

                }
            }

            return new string(givenNumberArray);
        }

    }
}
