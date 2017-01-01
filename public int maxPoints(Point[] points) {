        public int maxPoints(Point[] points) {
        	if (points==null) return 0;
        	if (points.length<=2) return points.length;
        	
        	Map<Integer,Map<Integer,Integer>> map = new HashMap<Integer,Map<Integer,Integer>>();
        	int result=0;
        	for (int i=0;i<points.length;i++){ 
        		map.clear();
        		int overlap=0,max=0;
        		for (int j=i+1;j<points.length;j++){
        			//y1 = ax1 + k, y2 = ax2 + k
        			//=> a = (y1-y2)/(x1-x2) 
        			int x=points[j].x-points[i].x;
        			int y=points[j].y-points[i].y;
        			
        			//if there are duplicate points
        			if (x==0&&y==0){
        				overlap++;
        				continue;
        			}
        			
        			//约分
        			int gcd=generateGCD(x,y);
        			if (gcd!=0){
        				x/=gcd;
        				y/=gcd;
        			}
        			
        			//map<x,<y,count>>
        			if (map.containsKey(x)){
        				/*if (map.get(x).containsKey(y)){
        					map.get(x).put(y, map.get(x).get(y)+1);
        				}else{
        					map.get(x).put(y, 1);
        				} */
        				map.get(x).put(y, map.get(x).getOrDefault(y, 0) + 1);
        			}else{
        				Map<Integer,Integer> m = new HashMap<Integer,Integer>();
        				m.put(y, 1);
        				map.put(x, m);
        			}
        			max=Math.max(max, map.get(x).get(y));
        		}
        		result=Math.max(result, max+overlap+1); //+1 是i本身
        	}
        	return result;
        }
        
        private int generateGCD(int a,int b){
        	if (b==0) return a;
        	else return generateGCD(b,a%b);
        }