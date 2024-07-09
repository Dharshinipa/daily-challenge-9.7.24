class Solution {
    public double averageWaitingTime(int[][] customers) {
        
        /*
        let the total waiting time be 0 and
        the current time be the first customer's entry time.
        */
         double total_time = 0;
        int curr_time = customers[0][0];
        
        
        for(int[] customer: customers) {
            
            int came_at = customer[0];
            int waiting_time = customer[1];
            
            /*
            when the customer enters we will see if the current time stored,
            is less than the time at which the customer enters,
            If yes, it means that the chef was free for the timeperiod of 
            (came_at - curr_time) units, and the customer entering will place
            the order and just wait till his waiting time.
            */
            
            if(curr_time < came_at) {
                curr_time = came_at;
            }
            
            /*
            The waiting till will always be considered.
            (curr_time-came_at) indicates the waiting time for previous order
            to complete.
            */
            total_time += waiting_time;
            total_time += curr_time - came_at;
            /*
            The curr_time will increase because of the cokking time of
            previous orders.
            */
            curr_time += waiting_time;
        
        }
        
        double ans = total_time*1.0/customers.length;
        return ans;
    }
}
