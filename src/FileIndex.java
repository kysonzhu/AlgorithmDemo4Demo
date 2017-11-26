import java.util.HashMap;

import com.kyson.chapter1.section1.BinomialSample;
import com.kyson.chapter1.section1.DumplicateElements;
import com.kyson.chapter1.section1.EquivalentKey;
import com.kyson.chapter1.section1.Histogram;
import com.kyson.chapter1.section1.HistogramSample;
import com.kyson.chapter1.section2.BinarySearchCounter;
import com.kyson.chapter1.section2.CircularRotation;
import com.kyson.chapter1.section2.Interval1D;
import com.kyson.chapter1.section2.Interval2D;
import com.kyson.chapter1.section2.Point2D;
import com.kyson.chapter1.section2.SmartDate1;
import com.kyson.chapter1.section2.SmartDate2;
import com.kyson.chapter1.section2.Transaction;
import com.kyson.chapter1.section2.VisualCounter;
import com.kyson.chapter1.section3.CircularLinkedListQueue;
import com.kyson.chapter1.section3.Date1;
import com.kyson.chapter1.section3.DoublingStackOfStrings;
import com.kyson.chapter1.section3.EvaluatePostfix;
import com.kyson.chapter1.section3.FixedCapacityStackOfStrings;
import com.kyson.chapter1.section3.GeneralizedQueue;
import com.kyson.chapter1.section3.InfixToPostfix;
import com.kyson.chapter1.section3.Josephus;
import com.kyson.chapter1.section3.LinkedListExecise1;
import com.kyson.chapter1.section3.LinkedListExecise2;
import com.kyson.chapter1.section3.LinkedListExecise3;
import com.kyson.chapter1.section3.LinkedListExecise4;
import com.kyson.chapter1.section3.LinkedListExecise5;
import com.kyson.chapter1.section3.LinkedListExecise6;
import com.kyson.chapter1.section3.LinkedListExecise7;
import com.kyson.chapter1.section3.LinkedListExecise8;
import com.kyson.chapter1.section3.Parentheses;
import com.kyson.chapter1.section3.QueueExecise1;
import com.kyson.chapter1.section3.RandomBag;
import com.kyson.chapter1.section3.RandomQueue;
import com.kyson.chapter1.section3.ResizingArrayQueueOfStrings;
import com.kyson.chapter1.section3.RingBuffer;
import com.kyson.chapter1.section3.Stack;
import com.kyson.chapter1.section3.Stack2;
import com.kyson.chapter1.section3.Steque;
import com.kyson.chapter1.section4.ThreeSum2;

public class FileIndex {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        HashMap<String, String> map = new HashMap<String, String>();

        /****
         * section 1
         */
        // 找到重复元素

        map.put("1.1.15", HistogramSample.class.getName());
        map.put("1.1.27", BinomialSample.class.getName());
        map.put("1.1.28", DumplicateElements.class.getName());
        map.put("1.1.29", EquivalentKey.class.getName());
        map.put("1.1.32", Histogram.class.getName());

        /***
         * section 2
         */
        map.put("1.2.1", Point2D.class.getName());
        map.put("1.2.2", Interval1D.class.getName());
        map.put("1.2.3", Interval2D.class.getName());
        map.put("1.2.6", CircularRotation.class.getName());
        map.put("1.2.9", BinarySearchCounter.class.getName());
        map.put("1.2.10", VisualCounter.class.getName());
        map.put("1.2.11", SmartDate1.class.getName());
        map.put("1.2.12", SmartDate2.class.getName());
        map.put("1.2.13", Transaction.class.getName());
        map.put("1.2.14", Transaction.class.getName());

        /***
         * section 3
         */
        map.put("1.3.1", FixedCapacityStackOfStrings.class.getName());
        map.put("1.3.2", Stack.class.getName());
        map.put("1.3.4", Parentheses.class.getName());
        map.put("1.3.8", DoublingStackOfStrings.class.getName());
        map.put("1.3.10", InfixToPostfix.class.getName());
        map.put("1.3.11", EvaluatePostfix.class.getName());
        map.put("1.3.12", Stack2.class.getName());
        map.put("1.3.14", ResizingArrayQueueOfStrings.class.getName());
        map.put("1.3.15", QueueExecise1.class.getName());
        map.put("1.3.16", Date1.class.getName());
        map.put("1.3.19", LinkedListExecise1.class.getName());
        map.put("1.3.20", LinkedListExecise2.class.getName());
        map.put("1.3.21", LinkedListExecise3.class.getName());
        map.put("1.3.24", LinkedListExecise4.class.getName());
        map.put("1.3.25", LinkedListExecise5.class.getName());
        map.put("1.3.26", LinkedListExecise6.class.getName());
        map.put("1.3.27", LinkedListExecise7.class.getName());
        map.put("1.3.29", CircularLinkedListQueue.class.getName());
        map.put("1.3.30", LinkedListExecise8.class.getName());

        map.put("1.3.32", Steque.class.getName());
        map.put("1.3.34", RandomBag.class.getName());
        map.put("1.3.35", RandomQueue.class.getName());
        map.put("1.3.37", Josephus.class.getName());
        map.put("1.3.38", GeneralizedQueue.class.getName());
        map.put("1.3.39", RingBuffer.class.getName());

        /***
         * section 3
         */
        map.put("1.4.2", ThreeSum2.class.getName());

    }

}
